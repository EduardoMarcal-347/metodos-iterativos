public class JacobiMethod {

		public static double[] jacobi(double[][] coeficientes, double[] termosIndependentes, int maxIteracoes, double precisao) {
				int n = coeficientes.length;
				double[] solucaoAtual = new double[n];
				double[] solucaoProxima = new double[n];

				for (int iteracao = 0; iteracao < maxIteracoes; iteracao++) {
						for (int i = 0; i < n; i++) {
								double soma = termosIndependentes[i];
								for (int j = 0; j < n; j++) {
										if (j != i) {
												soma -= coeficientes[i][j] * solucaoAtual[j];
										}
								}
								solucaoProxima[i] = soma / coeficientes[i][i];
						}

						// Verifica a convergência
						if (normaInfinidade(subtrairVetores(solucaoProxima, solucaoAtual)) < precisao) {
								return solucaoProxima;
						}

						// Atualiza a solução para a próxima iteração
						solucaoAtual = solucaoProxima.clone();
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

		private static double[] subtrairVetores(double[] vetor1, double[] vetor2) {
				int n = vetor1.length;
				double[] resultado = new double[n];
				for (int i = 0; i < n; i++) {
						resultado[i] = vetor1[i] - vetor2[i];
				}
				return resultado;
		}

}
