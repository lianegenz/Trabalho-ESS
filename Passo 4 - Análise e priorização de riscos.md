## 8. Análise e priorização de riscos

A avaliação dos riscos foi elaborada com base nas ameaças identificadas por meio do STRIDE e nos casos de abuso apresentados nas etapas anteriores.

Para determinar o nível de cada risco, foram considerados os seguintes aspectos:

* o acontecimento que pode gerar algum tipo de dano;
* a ameaça associada ao acontecimento;
* a vulnerabilidade ou circunstância que possibilita o evento;
* a possibilidade de o evento acontecer;
* os impactos que podem ser provocados;
* a pontuação obtida e seu respectivo grau de prioridade.

### 8.1 Critérios de probabilidade

| Valor | Classificação | Critério utilizado                                                                                                              |
| ----- | ------------- | --------------------------------------------------------------------------------------------------------------------------------|
| 1     | Baixa         | A ocorrência depende de situações pouco comuns, privilégios de acesso específicos ou conhecimentos técnicos elevados            |
| 2     | Média-baixa   | O acontecimento pode ocorrer, porém necessita da existência de uma vulnerabilidade ou circunstância particular                  |
| 3     | Média-alta    | A ocorrência é considerada plausível e pode acontecer em situações usuais de utilização ou exploração do sistema                |
| 4     | Alta          | O evento apresenta facilidade de ocorrência, pode acontecer com frequência ou está associado a condições previsíveis do sistema |

### 8.2 Critérios de impacto

| Valor | Classificação | Critério utilizado                                                                                                        |
| ----- | ------------- | --------------------------------------------------------------------------------------------------------------------------|
| 1     | Baixo         | Provoca uma pequena inconveniência e pode ser solucionado em pouco tempo                                                  |
| 2     | Moderado      | Pode provocar uma interrupção ou inconsistência limitada, sendo possível recuperar o funcionamento posteriormente         |
| 3     | Alto          | Pode gerar impactos financeiros ou administrativos, além de possibilitar uma exposição significativa de informações       |
| 4     | Muito alto    | Pode atingir um grande número de usuários, comprometer atividades essenciais do sistema ou ocasionar consequências graves |


### 8.3 Cálculo e classificação

Para este projeto, foram definidos os seguintes intervalos de classificação:

`Pontuação = Probabilidade × Impacto`

| Pontuação | Nível do risco |
| --------- | -------------- |
| 1 a 3     | Baixo          |
| 4 a 7     | Médio          |
| 8 a 11    | Alto           |
| 12 a 16   | Crítico        |

A pontuação obtida serve como um mecanismo para facilitar a comparação e a definição da prioridade entre os riscos. Entretanto, ela não deve ser analisada de forma isolada, sendo necessário considerar também a justificativa e as características específicas de cada situação.
