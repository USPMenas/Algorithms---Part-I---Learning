#include <iostream>
#include "pilha.h"

using namespace std;

int main()
{
    pilha pilha1;
    TipoItem item;
    int opcao;

    cout << "Programa gerador de pilhas: \n";
    do
    {
        cout << "Digite 0 para parar o programa! \n";
        cout << "Digite 1 para inserir um elemento! \n";
        cout << "Digite 2 para remover um elemento! \n";
        cout << "Digite 3 para imprimir a pilha! \n";
        cin >> opcao;
        switch (opcao)
        {
        case 1:
            cout << "Digite um numero inteiro: ";
            cin >> item;
            pilha1.inserir(item);
            break;
        case 2:
            if (!pilha1.is_empty())
            {
                item = pilha1.remover();
                cout << "Elemento removido: " << item << endl;
            }
            break;
        case 3:
            pilha1.imprimir();
            break;
        default:
            cout << "Opcao invalida! \n";
        }
    } while (opcao != 0);

    return 0;
}