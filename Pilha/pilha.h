typedef int TipoItem;
const int max_itens = 100;

class pilha
{
private:
    int tamanho;
    TipoItem *estrutura;

public:
    pilha();                     // construtora
    ~pilha();                    // destrutora
    bool is_full();              // verifica se a pilha está cheia
    bool is_empty();             // verifica se a plha está vazia
    void inserir(TipoItem item); // push
    TipoItem remover();          // pop
    void imprimir();             // print
    int qual_tamanho();          // lenght
};