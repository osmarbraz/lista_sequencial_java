
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
     * Insere um elemento em uma posição especifica da lista.
     *
     * @param _lista Lista dos elementos.
     * @param _novo Novo valor a ser inserido.
     * @param _k Posição a ser inserida o valor.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirPosicao(int[] _lista, int _novo, int _k) {
        if (n < TAMANHO_LISTA) {
            //Verifica se a posição está no intervalo de valores da lista.
            if ((_k >= 0) && (_k <= n)) {
                //Desloca os elementos do fim até a posição k
                for (int i = n - 1; i >= _k; i--) {
                    _lista[i + 1] = _lista[i];
                }
                //Insere o novo valor na posição k.
                _lista[_k] = _novo;
                //Incrementa a quantidade de elementos.
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
     * Insere um elemento no início da lista.
     *
     * @param _lista Lista dos elementos.
     * @param _novo Novo valor a ser inserido.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirInicio(int[] _lista, int _novo) {
        return inserirPosicao(_lista, _novo, 0);
    }

    /**
     * Insere um elemento no final da lista.
     *
     * @param _lista Lista dos elementos.
     * @param _novo Novo valor a ser inserido.
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirFim(int[] _lista, int _novo) {
        return inserirPosicao(_lista, _novo, n);
    }

    /**
     * Inclui de forma ordenado um elemento na lista levando em consideração o
     * seu valor.
     *
     * @param _lista Lista dos elementos.
     * @param _novo Novo valor a ser inserido.
     *
     * @return Verdadeiro ou falso se conseguiu incluir o novo valor.
     */
    public static boolean inserirOrdenado(int[] _lista, int _novo) {
        if (n < TAMANHO_LISTA) {
            int i = 0;
            while ((i < n) && (_novo > _lista[i])) {
                i = i + 1;
            }
            if (i <= n) {
                return inserirPosicao(_lista, _novo, i);
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
     * Excluir um elemento da lista pela posição.
     *
     * @param _lista Lista com os valores.
     * @param _k Posição do elemento a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor da posição.
     */
    public static boolean excluirPosicao(int[] _lista, int _k) {
        if (n != 0) {
            //Verifica se a posição está no intervalo de elementos da lista.
            if ((_k >= 0) && (_k < n)) {
                //Desloca os elementos do fim até a posição k da lista.
                for (int i = _k; i < n; i++) {
                    _lista[i] = _lista[i + 1];
                }
                //Decrementa a quantidade de elementos da lista.
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
     * Excluir um elemento do final da lista.
     *
     * @param _lista Lista dos elementos.
     * @return Verdadeiro ou falso se excluiu o valor do final.
     */
    public static boolean excluirFim(int[] _lista) {
        return excluirPosicao(_lista, n - 1);
    }

    /**
     * Excluir um elemento do início da lista.
     *
     * @param _lista Lista dos elementos.
     * @return Verdadeiro ou falso se excluiu o valor do início.
     */
    public static boolean excluirInicio(int[] _lista) {
        return excluirPosicao(_lista, 0);
    }

    /**
     * Excluir um elemento da lista pelo valor.
     *
     * @param _lista Lista dos elementos.
     * @param _valor Valor a ser excluído da lista.
     * @return Verdadeiro ou falso se excluiu o valor.
     */
    public static boolean excluirValor(int[] _lista, int _valor) {
        if (n != 0) {
            int i = 0;
            //Procura a posição do elemento na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((i < n) && (_valor != _lista[i])) {
                i = i + 1;
            }
            //Verifica se a posição esta dentro do intervalo da lista
            if (i < n) {
                //Chama o método excluir para a posição i
                excluirPosicao(_lista, i);
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
     * Retorna a posição de um elemento na lista.
     *
     * @param _lista Lista dos elementos.
     * @param _valor Valor a ser procurado na lista.
     * @return A posição de valor na lsita.
     */
    public static int posicaoValor(int[] _lista, int _valor) {
        if (n != 0) {
            int i = 0;
            //Procura a posição do elemento na lista.
            //Compara o valor na lista ou até chegar no final da lista.
            while ((i < n) && (_valor != _lista[i])) {
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
     * @param _lista Lista para exibir os dados.
     * @param _n Quantidade de elementos da lista.
     */
    public static void listar(int[] _lista, int _n) {
        String temp = "";
        for (int i = 0; i < _n; i++) {
            temp = temp + (i) + "-" + _lista[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, "Listagem \n" + temp);
    }

    /**
     * Mosta na tela a quantidade de elementos da lista
     */
    public static void mostrarQuantidade() {
        JOptionPane.showMessageDialog(null, "Quantidade de elementos na lista : " + quantidadeLista());
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
     * Retorna a quantidade de elementos da lista.
     *
     * @return A quantidade de elementos da lista.
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
                    + " 1- Listar elementos\n"
                    + " 2- Inserir elemento no início\n"
                    + " 3- Inserir elemento no fim\n"
                    + " 4- Inserir elemento em uma posição especifica\n"
                    + " 5- Inserir elemento ordenado\n"
                    + " 6- Remover elemento do início\n"
                    + " 7- Remover elemento do fim\n"
                    + " 8- Remover elemento de uma posição específica\n"
                    + " 9- Remover elemento pelo valor\n"
                    + "10- Mostrar a posição de um elemento\n"
                    + "11- Mostrar a quantidade de elementos\n"
                    + "12- Está cheia?\n"
                    + "13- Está vazia?\n"
                    + "99- Sair\n"));
            switch (opcao) {
                case 1: {
                    if (estaVazia()) {
                        JOptionPane.showMessageDialog(null, "Lista vazia!");
                    } else {
                        listar(lista, n);
                    }
                    break;
                }
                case 2: {
                    if (inserirInicio(lista, leitura()) == true) {
                        JOptionPane.showMessageDialog(null, "Elemento inserido no início com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento não inserido no início!");
                    }
                    break;
                }
                case 3: {
                    if (inserirFim(lista, leitura()) == true) {
                        JOptionPane.showMessageDialog(null, "Elemento inserido no fim com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento não inserido no fim!");
                    }
                    break;
                }
                case 4: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posicao:"));
                    int novo = leitura();
                    if (inserirPosicao(lista, novo, k) == true) {
                        JOptionPane.showMessageDialog(null, "Elemento inserido na posição " + k + " com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento não inserido na posição " + k + "!");
                    }
                    break;
                }
                case 5: {
                    if (inserirOrdenado(lista, leitura()) == true) {
                        JOptionPane.showMessageDialog(null, "Elemento inserido ordenado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento não inserido ordenado!");
                    }
                    break;
                }
                case 6: {
                    if (excluirInicio(lista)) {
                        JOptionPane.showMessageDialog(null, "O elemento da início foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento do início não foi excluído!");
                    }
                    break;
                }
                case 7: {
                    if (excluirFim(lista)) {
                        JOptionPane.showMessageDialog(null, "O elemento da fim foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento do fim não foi excluído!");
                    }
                    break;
                }
                case 8: {
                    int k = Integer.parseInt(JOptionPane.showInputDialog("Digite a posicao:"));
                    if (excluirPosicao(lista, k)) {
                        JOptionPane.showMessageDialog(null, "O valor da posição " + k + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 9: {
                    int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento:"));
                    if (excluirValor(lista, valor)) {
                        JOptionPane.showMessageDialog(null, "O valor " + valor + " foi excluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi excluído!");
                    }
                    break;
                }
                case 10: {
                    int novo = leitura();
                    int posicao = posicaoValor(lista, novo);
                    JOptionPane.showMessageDialog(null, "O valor " + novo + " esta na posição " + posicao);
                    break;
                }
                case 11: {
                    mostrarQuantidade();
                    break;
                }
                case 12: {
                    JOptionPane.showMessageDialog(null, "Está cheia : " + estaCheia());
                    break;
                }
                case 13: {
                    JOptionPane.showMessageDialog(null, "Está vazia : " + estaVazia());
                    break;
                }
            }
        }
    }
}
