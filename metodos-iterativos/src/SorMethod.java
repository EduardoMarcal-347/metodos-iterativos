public class SorMethod {

		public static double[] sor(double[][] coeficientes, double[] termosIndependentes, int maxIteracoes, double precisao, double omega) {
				int n = coeficientes.length;
				double[] solucaoAtual = new double[n];

				for (int iteracao = 0; iteracao < maxIteracoes; iteracao++) {
						for (int i = 0; i < n; i++) {
								double soma = termosIndependentes[i];
								for (int j = 0; j < n; j++) {
										if (j != i) {
												soma -= coeficientes[i][j] * solucaoAtual[j];
										}
								}
								solucaoAtual[i] = (1 - omega) * solucaoAtual[i] + (omega / coeficientes[i][i]) * soma;
						}

						// Verifica a convergência
						if (normaInfinidade(residuo(coeficientes, solucaoAtual, termosIndependentes)) < precisao) {
								return solucaoAtual;
						}
				}

				// Retorna a solução atual se atingir o número máximo de iterações
				return solucaoAtual;
		}

		private static double normaInfinidade(double[] vetor) {
				double norma = 0;
				for (double valor : vetor) {
						norma = Math.max(norma, Math.abs(valor));
				}
				return norma;
		}

		private static double[] residuo(double[][] coeficientes, double[] solucao, double[] termosIndependentes) {
				int n = coeficientes.length;
				double[] resultado = new double[n];
				for (int i = 0; i < n; i++) {
						double soma = termosIndependentes[i];
						for (int j = 0; j < n; j++) {
								soma -= coeficientes[i][j] * solucao[j];
						}
						resultado[i] = soma;
				}
				return resultado;
		}
}
