## O Desafio
Considere o seguinte jogo hipotético, que chamaremos de SeuPrimeiroMilhao,
muito semelhante a Banco Imobiliário, onde várias de suas mecânicas foram
simplificadas. Numa partida desse jogo, os jogadores se alteram em rodadas, numa
ordem definida aleatoriamente no começo da partida. Os jogadores sempre começam
uma partida com saldo de 300 para cada um.


Nesse jogo, o tabuleiro é composto por 20 propriedades em sequência. Cada propriedade tem
um custo de venda, um valor de aluguel, um proprietário caso já estejam compradas, e seguem
uma determinada ordem no tabuleiro. Em SeuPrimeiroMilhao, não é possível
construir hotéis e nenhuma outra melhoria sobre as propriedades do tabuleiro, por
simplicidade do problema.

O valor de venda e de aluguel de todas as 20 propriedades são configurados em um
arquivo de nome `gameConfig.txt`, que seu programa deve ler e interpretar. Os
detalhes sobre a formatação do arquivo se encontram na seção Entrada.

No começo da sua vez, o jogador joga um dado equiprovável de 6 faces que determina
quantas espaços no tabuleiro o jogador vai andar.

+ Ao cair em uma propriedade sem proprietário, o jogador pode escolher entre
comprar ou não a propriedade. Esse é a única forma pela qual uma propriedade
pode ser comprada.

+ Ao cair em uma propriedade que tem proprietário, ele deve pagar ao proprietário o valor do
aluguel da propriedade.

+ Ao completar uma volta no tabuleiro, o jogador ganha 100 de saldo.

Jogadores só podem comprar propriedades caso ela não tenha dono e o jogador
tenha o dinheiro da venda. Ao comprar uma propriedade, o jogador perde o
dinheiro e ganha a posse da propriedade.

Cada um dos jogadores tem uma implementação de comportamento diferente,
que dita as ações que eles vão tomar ao longo do jogo. Mais detalhes sobre o
comportamento serão explicados mais à frente.

Um jogador que fica com saldo negativo perde o jogo, e não joga mais. 
Perde suas propriedades e portanto podem ser compradas por qualquer outro jogador.

SeuPrimeiroMilhao termina quando restar somente um jogador com saldo positivo, a
qualquer momento da partida. Esse jogador é declarado o vencedor.

Desejamos rodar uma simulação sobre SeuPrimeiroMilhao para decidir qual a melhor
estratégia. Para isso, idealizamos uma partida com 4 diferentes tipos de possíveis
jogadores. Os comportamentos definidos são:

+ O jogador um é impulsivo;

+ O jogador dois é exigente;

+ O jogador três é cauteloso;

+ O jogador quatro é aleatório;

O jogador *impulsivo* compra qualquer propriedade sobre a qual ele parar.

O jogador *exigente* compra qualquer propriedade, desde que o valor do aluguel dela seja
maior do que 50.

O jogador *cauteloso* compra qualquer propriedade desde que ele tenha uma
reserva de 80 saldo sobrando depois de realizada a compra.

O jogador *aleatório* compra a propriedade que ele parar em cima com
probabilidade de 50%.

Caso o jogo demore muito, como é de costume em jogos dessa natureza, o jogo
termina na milésima rodada com a vitória do jogador com mais saldo. O critério
de desempate é a ordem de turno dos jogadores nesta partida.

Dados esse padrão de comportamento dos jogadores e das regras de
SeuPrimeiroMilhao, queremos saber o seguinte:

+ Em 300 partidas, qual a distribuição de vitória por comportamento de
jogador? Existe algum comportamento que ganha mais que os outros?

+ Em média, quantas rodadas o jogo demora para terminar? Quantas partidas
de SeuPrimeiroMilhao terminam pelo critério de tempo?

### Entrada

Nesta seção definiremos qual o padrão esperado para o arquivo de entrada
`gameConfig.txt`, que dita o preço de venda e aluguel das propriedades. Esse arquivo
deve se encontrar na mesma pasta que os outros arquivos fonte do desafio, e deve
seguir a risca as instruções a seguir. Seu programa deve ler esse arquivo e configurar as
propriedades do jogo baseado nas informações encontradas nele.

Cada linha do arquivo `gameConfig.txt` contém informações a respeito de uma
propriedade. A primeira linha diz respeito a primeira das propriedades do tabuleiro, a
segunda diz a respeito da segunda propriedade, e assim por diante, descrevendo todas
as 20 propriedades do jogo.

Cada linha do tabuleiro contém dois valores inteiros. O primeiro é o valor de venda da
propriedade e o segundo é o seu valor de aluguel.
Dentro do conteúdo da pasta do desafio se encontra um exemplo de arquivo de entrada
que pode ser usado para rodar seu programa.

### Saída

Uma execução do programa proposto deve rodar 300 simulações de
SeuPrimeiroMilhao, imprimindo no console os dados referentes às execuções.
Esperamos encontrar nos dados as seguintes informações:

+ Quantas partidas terminam por _time out_ (1000 rodadas);

+ Quantos turnos em média demora uma partida;

+ Qual a porcentagem de vitórias por comportamento dos jogadores;

+ Qual o comportamento que mais vence.

