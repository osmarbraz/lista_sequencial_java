
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
     * Insere um Nó em uma posição especifica da lista.
     *
     * @param lista Lista dos nós.
     * @param novo Novo valor a ser inserido.
     * @param k Posição a ser inserida o valor.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirPosicao(int[] lista, int novo, int k) {
        if (n < TAMANHO_LISTA) {
            //Verifica se a posição está no intervalo de valores da lista.
            if ((k >= 0) && (k <= n)) {
                //Desloca os Nós do fim até a posição k
                for (int i = n - 1; i >= k; i--) {
                    lista[i + 1] = lista[i];
                }
                //Insere o novo valor na posição k.
                lista[k] = novo;
                //Incrementa a quantidade de Nós.
                n = n + 1;
                return true;
            } else {
                System.out.print("Posição inválida!\n");
                return false;
            }
        } else {
            System.out.print("A lista está cheia!\n");
            return false;
        }
    }

    /**
     * Insere um Nó no início da lista.
     *
     * @param lista Lista dos Nós.
     * @param novo Novo valor a ser inserido.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirInicio(int[] lista, int novo) {
        return inserirPosicao(lista, novo, 0);
    }

    /**
     * Insere um Nó no final da lista.
     *
     * @param lista Lista dos Nós.
     * @param novo Novo valor a ser inserido.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirFim(int[] lista, int novo) {
        return inserirPosicao(lista, novo, n);
    }

    /**
     * Inclui de forma ordenado um Nó na lista levando em consideração o
     * seu valor.
     *
     * @param lista Lista dos Nós.
     * @param novo Novo valor a ser inserido.
     *
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirOrdenado(int[] lista, int novo) {
        if (n < TAMANHO_LISTA) {
            int i = 0;
            while ((i < n) && (novo > lista[i])) {
                i = i + 1;
            }
            if (i <= n) {
                return inserirPosicao(lista, novo, i);
            } else {
                System.out.print("Posição Inválida!");
                return false;
            }
        } else {
            System.out.print("A lista está cheia!\n");
            return false;
        }
    }

    /**
     * Excluir um Nó da lista pela posição.
     *
     * @param lista Lista com os valores.
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
                System.out.print("Posicao invalida!\n");
                return false;
            }
        } else {
            System.out.print("A lista está vazia!\n");
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
        return excluirPosicao(lista, n - 1);
    }

    /**
     * Excluir um Nó do início da lista.
     *
     * @param lista Lista dos Nós.
     * @return Verdadeiro ou falso se excluiu o valor do início.
     */
    public static boolean excluirInicio(int[] lista) {
        return excluirPosicao(lista, 0);
    }

    /**
     * Excluir um Nó da lista pelo valor.
     *
     * @param lista Lista dos Nós.
     * @param valor Valor a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor.
     */
    public static boolean excluirValor(int[] lista, int valor) {
        if (n != 0) {
            int i = 0;
            //Procura a posição do Nó na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((i < n) && (valor != lista[i])) {
                i = i + 1;
            }
            //Verifica se a posição esta dentro do intervalo da lista
            if (i < n) {
                //Chama o método excluir para a posição i
                excluirPosicao(lista, i);
                return true;
            } else {
                System.out.print("Valor nao existe na lista!\n");
                return false;
            }
        } else {
            System.out.print("Lista Vazia!");
            return false;
        }
    }

    /**
     * Retorna a posição de um Nó na lista.
     *
     * @param lista Lista dos Nós.
     * @param valor Valor a ser procurado na lista.
     * @return A posição de valor na lsita.
     */
    public static int posicaoValor(int[] lista, int valor) {
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
            System.out.print("Lista Vazia!");
            return -1;
        }
    }

    /**
     * Lista os dados da lista.
     *
     * @param lista Lista para exibir os dados.
     * @param n Quantidade de Nós da lista.
     * @return Uma String com os dados da lista.
     */
    public static String listar(int[] lista, int n) {
        String temp = "";
        for (int i = 0; i < n; i++) {
            temp = temp + (i) + "-" + lista[i] + "\n";
        }
        return temp;        
    }

    /**
     * Mosta na tela a quantidade de Nós da lista
     */
    public static void mostrarQuantidade() {
        JOptionPane.showMessageDialog(null, "Quantidade de Nós na lista : " + quantidadeLista());
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
    public static int quantidadeLista() {
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
                    + "10- Mostrar a posição de um Nó\n"
                    + "11- Mostrar a quantidade de Nós\n"
                    + "12- Está cheia?\n"
                    + "13- Está vazia?\n"
                    + "99- Sair\n"));
            switch (opcao) {
                case 1: {
                    if (estaVazia()) {
                        JOptionPane.showMessageDialog(null, "Lista vazia!");
                    } else {                        
                        JOptionPane.showMessageDialog(null, "Listagem \n" + listar(lista,n));
                    }
                    break;
                }
                case 2: {
                    if (inserirInicio(lista, leitura()) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido no início com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido no início!");
                    }
                    break;
                }
                case 3: {
                    if (inserirFim(lista, leitura()) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido no fim com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido no fim!");
                    }
                    break;
                }
                case 4: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posicao:"));
                    int novo = leitura();
                    if (inserirPosicao(lista, novo, k) == true) {
                        JOptionPane.showMessageDialog(null, "Nó inserido na posição " + k + " com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó não inserido na posição " + k + "!");
                    }
                    break;
                }
                case 5: {
                    if (inserirOrdenado(lista, leitura()) == true) {
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
                    int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do Nó a ser excluído:"));
                    if (excluirValor(lista, valor)) {
                        JOptionPane.showMessageDialog(null, "O valor " + valor + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 10: {
                    int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor a ser procurado:"));
                    int posicao = posicaoValor(lista, valor);
                    JOptionPane.showMessageDialog(null, "O valor " + valor + " esta na posição " + posicao);
                    break;
                }
                case 11: {
                    mostrarQuantidade();
                    break;
                }
                case 12: {
                    JOptionPane.showMessageDialog(null, "Lista está cheia : " + estaCheia());
                    break;
                }
                case 13: {
                    JOptionPane.showMessageDialog(null, "Lista está vazia : " + estaVazia());
                    break;
                }
            }
        }
    }
}
