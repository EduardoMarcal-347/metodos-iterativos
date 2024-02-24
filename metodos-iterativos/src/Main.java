public class Main {
		public static void main(String[] args) {
				double[][] coeficientes = {
								{-4, 1, 0, 1, 0, 0, 0, 0, 0},
								{1, -4, 1, 0, 1, 0, 0, 0, 0},
								{0, 1, -4, 0, 0, 1, 0, 0, 0},
								{1, 0, 0, -4, 1, 0, 1, 0, 0},
								{0, 1, 0, 1, -4, 1, 0, 1, 0},
								{0, 0, 1, 0, 1, -4, 0, 0, 1},
								{0, 0, 0, 1, 0, 0, -4, 1, 0},
								{0, 0, 0, 0, 1, 0, 1, -4, 1},
								{0, 0, 0, 0, 0, 1, 0, 1, -4},
				};

				double[] termosIndependentes = {-50, -50, -150, 0, 0, -100, -50, -50 ,-150};
				int maxIteracoes = 100;
				double precisao = 1e-8;

				double[] omega = {0.5, 0.9, 1.2, 1.5};

				JacobiMethod jacobiMethod = new JacobiMethod();
				GaussSeidelMethod gaussSeidelMethod = new GaussSeidelMethod();
				SorMethod sorMethod = new SorMethod();

//				double[] solucao = jacobiMethod.jacobi(coeficientes, termosIndependentes, maxIteracoes, precisao);
//				double[] solucao = gaussSeidelMethod.gaussSeidel(coeficientes, termosIndependentes, maxIteracoes, precisao);
				double[] solucao = sorMethod.sor(coeficientes, termosIndependentes, maxIteracoes, precisao, omega[0]);

				// Imprima ou utilize a solução conforme necessário
				for (int i = 0; i < solucao.length; i++) {
						System.out.println("u" + (i + 1) + ": " + solucao[i]);
				}
		}


}