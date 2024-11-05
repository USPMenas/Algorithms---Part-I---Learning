#include <iostream>
#include "pilha.h"

using namespace std;

pilha::pilha()
{
    tamanho = 0;
    estrutura = new TipoItem[max_itens];
}
// construtora
pilha::~pilha()
{
    delete[] estrutura;
}
// destrutora
bool pilha::is_full()
{
    return (tamanho == max_itens);
}
// verifica se a pilha está cheia
bool pilha::is_empty()
{
    return (tamanho == 0);
}
// verifica se a plha está vazia
void pilha::inserir(TipoItem item)
{
    if (is_full())
    {
        cout << "Pilha cheia! \n";
    }
    else
    {
        estrutura[tamanho] = item;
        tamanho++;
    }
}
// push
TipoItem pilha::remover()
{
    if (is_empty())
    {
        cout << "Pilha vazia! \n";
        return -1;
    }
    else
    {
        TipoItem item_removido = estrutura[tamanho - 1];
        tamanho--;
        return item_removido;
    }
}
// pop
void pilha::imprimir()
{
    cout << "Pilha: [ ";
    for (int i = 0; i < tamanho; i++)
    {
        cout << estrutura[i] << " ";
    }
    cout << "]\n";
}
// print
int pilha::qual_tamanho()
{
    return tamanho;
}
// lenght