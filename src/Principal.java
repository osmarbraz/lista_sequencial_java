
/**
 * Implementação de Lista Sequencial de forma estruturada.
 *
 */
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Tamanho máximo da lista.
     */
    private static final int TAMANHO_LISTA = 100;
    /**
     * Tamanho atual da fila.
     */
    private static int n = 0;

    /**
     * Realiza a leitura dos dados dos nós.
     *
     * @return O valor lido.
     */
    public static int leitura() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite um valor:"));
    }

    /**
     * Insere um Nó no início da lista.
     *
     * @param lista Lista dos Nós.
     * @param valor Um novo valor de um nó a ser inserido na lista.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirInicio(int[] lista, int valor) {
        if (n < TAMANHO_LISTA) {
            //Desloca os Nós do fim até a posição 0
            for (int i = n - 1; i >= 0; i--) {
                lista[i + 1] = lista[i];
            }
            //Insere o novo valor na posição 0.
            lista[0] = valor;
            //Incrementa a quantidade de Nós.
            n = n + 1;
            return true;
        } else {
            System.out.println("Inserir início - Lista cheia");
            return false;
        }
    }

    /**
     * Insere um Nó em uma posição especifica da lista.
     *
     * @param lista Lista dos nós.
     * @param valor Um novo valor de um nó a ser inserido na lista.
     * @param k Posição a ser inserida o valor.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirPosicao(int[] lista, int valor, int k) {
        if (n < TAMANHO_LISTA) {
            //Verifica se a posição está no intervalo de valores da lista.
            if ((k >= 0) && (k <= n)) {
                //Desloca os Nós do fim até a posição k
                for (int i = n - 1; i >= k; i--) {
                    lista[i + 1] = lista[i];
                }
                //Insere o novo valor na posição k.
                lista[k] = valor;
                //Incrementa a quantidade de Nós.
                n = n + 1;
                return true;
            } else {
                System.out.println("Inserir Posição - Posição inválida.");
                return false;
            }
        } else {
            System.out.println("Inserir Posição - Lista cheia.");
            return false;
        }
    }

    /**
     * Insere um Nó no final da lista.
     *
     * @param lista Lista dos Nós.
     * @param valor Um novo valor de um nó a ser inserido na lista.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirFim(int[] lista, int valor) {
        if (n < TAMANHO_LISTA) {
            //Insere o novo valor na posição n.
            lista[n] = valor;
            //Incrementa a quantidade de Nós.
            n = n + 1;
            return true;
        } else {
            System.out.println("Inserir Fim - Lista cheia.");
            return false;
        }
    }

    /**
     * Inclui de forma ordenado um Nó na lista levando em consideração o seu
     * valor.
     *
     * @param lista Lista dos Nós.
     * @param valor Um novo valor de um nó a ser inserido na lista.
     *
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirOrdenado(int[] lista, int valor) {
        if (n < TAMANHO_LISTA) {
            int j = 0;
            while ((j < n) && (valor > lista[j])) {
                j = j + 1;
            }
            if (j <= n) {
                //Desloca os Nós do fim até a posição j
                for (int i = n - 1; i >= j; i--) {
                    lista[i + 1] = lista[i];
                }
                //Insere o novo valor na posição j
                lista[j] = valor;
                //Incrementa a quantidade de Nós.
                n = n + 1;
                return true;
            }
            return false;
        } else {
            System.out.println("Inserir Ordenado - Lista cheia.");
            return false;
        }
    }

    /**
     * Excluir um Nó do início da lista.
     *
     * @param lista Lista dos Nós.
     * @return Verdadeiro ou falso se excluiu o valor do início.
     */
    public static boolean excluirInicio(int[] lista) {
        if (n != 0) {
            //Desloca os Nós do fim até a posição k da lista.
            for (int i = 0; i < n; i++) {
                lista[i] = lista[i + 1];
            }
            //Decrementa a quantidade de Nós da lista.
            n = n - 1;
            return true;
        } else {
            System.out.println("Excluir início - Lista vazia.");
            return false;
        }
    }

    /**
     * Excluir um Nó da lista pela posição.
     *
     * @param lista Lista dos Nós.
     * @param k Posição do Nó a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor da posição.
     */
    public static boolean excluirPosicao(int[] lista, int k) {
        if (n != 0) {
            //Verifica se a posição está no intervalo de Nós da lista.
            if ((k >= 0) && (k < n)) {
                //Desloca os Nós do fim até a posição k da lista.
                for (int i = k; i < n; i++) {
                    lista[i] = lista[i + 1];
                }
                //Decrementa a quantidade de Nós da lista.
                n = n - 1;
                return true;
            } else {
                System.out.println("Excluir início - Posição inválida.");
                return false;
            }
        } else {
            System.out.println("Excluir posição - Lista vazia.");
            return false;
        }
    }

    /**
     * Excluir um Nó do final da lista.
     *
     * @param lista Lista dos Nós.
     * @return Verdadeiro ou falso se excluiu o valor do final.
     */
    public static boolean excluirFim(int[] lista) {
        if (n != 0) {
            //atribui 0 para posição final
            lista[n - 1] = 0;
            //Decrementa a quantidade de Nós da lista.
            n = n - 1;
            return true;
        } else {
            System.out.println("Excluir fim - Lista vazia.");
            return false;
        }
    }

    /**
     * Excluir um Nó da lista pelo valor.
     *
     * @param lista Lista dos Nós.
     * @param valor Um valor de um nó a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor.
     */
    public static boolean excluirValor(int[] lista, int valor) {
        if (n != 0) {
            int j = 0;
            //Procura a posição do Nó na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((j < n) && (valor != lista[j])) {
                j = j + 1;
            }
            //Verifica se a posição esta dentro do intervalo da lista
            if (j < n) {
                //Desloca os Nós do fim até a posição j da lista.
                for (int i = j; i < n; i++) {
                    lista[i] = lista[i + 1];
                }
                //Decrementa a quantidade de Nós da lista.
                n = n - 1;
                return true;
            } else {
                System.out.println("Excluir valor - Valor não esta na lista.");
                return false;
            }
        } else {
            System.out.println("Excluir valor - Lista vazia.");
            return false;
        }
    }

    /**
     * Retorna o dado de uma posição na lista.
     *
     * @param lista Lista dos Nós.
     * @param k Posição do nó a ser consultado na lista.
     * @return A posição de valor na lsita.
     */
    public static int procurarPosicao(int[] lista, int k) {
        if (n != 0) {
            //Verifica se a posição esta dentro do intervalo da lista
            if ((k >= 0) && (k < n)) {
                return lista[k];
            } else {
                System.out.println("Procurar posição - Posição inválida.");
                return -1;
            }
        } else {
            System.out.println("Procurar posição - Lista vazia.");
            return -1;
        }
    }

    /**
     * Retorna a posição de um Nó na lista.
     *
     * @param lista Lista dos Nós.
     * @param valor Valor a ser procurado na lista.
     * @return A posição de valor na lsita.
     */
    public static int procurarValor(int[] lista, int valor) {
        if (n != 0) {
            int i = 0;
            //Procura a posição do Nó na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((i < n) && (valor != lista[i])) {
                i = i + 1;
            }
            //Verifica se a posição esta dentro do intervalo da lista
            if (i < n) {
                return i;
            } else {
                return -1;
            }
        } else {
            System.out.println("Procurar valor - Lista vazia.");
            return -1;
        }
    }

    /**
     * Lista os dados da lista.
     *
     * @param lista Lista dos Nós.
     * @param n Quantidade de Nós da lista.
     * @return Uma String com os dados da lista.
     */
    public static String listar(int[] lista, int n) {
        //String de retorno
        String temp = "";
        for (int i = 0; i < n; i++) {
            temp = temp + (i) + "-" + lista[i] + "\n";
        }
        return temp;
    }

    /**
     * Retorna se a lista está cheia.
     *
     * @return Verdadeiro ou falso se a lista está cheia.
     */
    public static boolean estaCheia() {
        return n == TAMANHO_LISTA;
    }

    /**
     * Retorna se a lista esta vazia.
     *
     * @return Verdadeiro ou falso se a lista está vazia.
     */
    public static boolean estaVazia() {
        return n == 0;
    }

    /**
     * Retorna a quantidade de Nós da lista.
     *
     * @return A quantidade de Nós da lista.
     */
    public static int getQuantidade() {
        return n;
    }

    public static void main(String[] args) {
        /**
         * Declaração da lista
         */
        int lista[] = new int[TAMANHO_LISTA];

        // Controla o menu da lista
        int opcao = -1;

        while (opcao != 99) {
            //Monta o menu de opções
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Lista Sequencial ###\n"
                    + "Selecione a opção desejada:\n"
                    + " 1- Listar Nós\n"
                    + " 2- Inserir Nó no início\n"
                    + " 3- Inserir Nó no fim\n"
                    + " 4- Inserir Nó em uma posição especifica\n"
                    + " 5- Inserir Nó ordenado\n"
                    + " 6- Remover Nó do início\n"
                    + " 7- Remover Nó do fim\n"
                    + " 8- Remover Nó de uma posição específica\n"
                    + " 9- Remover Nó pelo valor\n"
                    + "10- Procurar o dado de uma posição específica\n"
                    + "11- Procurar a posição de um dado\n"
                    + "12- Mostrar a quantidade de Nós\n"
                    + "13- Está cheia?\n"
                    + "14- Está vazia?\n"
                    + "99- Sair\n"));
            switch (opcao) {
                case 1: {
                    if (estaVazia()) {
                        JOptionPane.showMessageDialog(null, "Lista vazia!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Listagem \n" + listar(lista, n));
                    }
                    break;
                }
                case 2: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (inserirInicio(lista, dado) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido no início com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido no início!");
                    }
                    break;
                }
                case 3: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (inserirFim(lista, dado) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido no fim com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido no fim!");
                    }
                    break;
                }
                case 4: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição a ser inserido:"));
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (inserirPosicao(lista, dado, k) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido na posição " + k + " com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido na posição " + k + "!");
                    }
                    break;
                }
                case 5: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (inserirOrdenado(lista, dado) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido ordenado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido ordenado!");
                    }
                    break;
                }
                case 6: {
                    if (excluirInicio(lista)) {
                        JOptionPane.showMessageDialog(null, "O Nó do início foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó do início não foi excluído!");
                    }
                    break;
                }
                case 7: {
                    if (excluirFim(lista)) {
                        JOptionPane.showMessageDialog(null, "O Nó da fim foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó do fim não foi excluído!");
                    }
                    break;
                }
                case 8: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição a ser excluída:"));
                    if (excluirPosicao(lista, k)) {
                        JOptionPane.showMessageDialog(null, "O valor da posição " + k + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 9: {
                    //Preenche o valor do dado                    
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do dado a ser excluído:"));
                    if (excluirValor(lista, dado)) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 10: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do dado a ser procurada:"));
                    int dado = procurarPosicao(lista, k);
                    if (dado != -1) {
                        JOptionPane.showMessageDialog(null, "O valor da posição " + k + "  possui o dado = " + dado);
                    } else {
                        JOptionPane.showMessageDialog(null, "A posição " + k + " não está preenchida");
                    }
                    break;
                }
                case 11: {
                    int chave = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do dado a ser procurado:"));
                    int posicao = procurarValor(lista, chave);
                    JOptionPane.showMessageDialog(null, "O valor " + chave + " esta na posição " + posicao);
                    break;
                }
                case 12: {
                    JOptionPane.showMessageDialog(null, "Quantidade de Nós na lista : " + getQuantidade());
                    break;
                }
                case 13: {
                    JOptionPane.showMessageDialog(null, "Lista está cheia : " + estaCheia());
                    break;
                }
                case 14: {
                    JOptionPane.showMessageDialog(null, "Lista está vazia : " + estaVazia());
                    break;
                }
            }//Fim Switch
        }//Fim While
    }//Fim main
}
