## Pipeline DevSecOps Proposto: Descrição textual (Planejamento, Código, Verificação, Operação)

O pipeline DevSecOps do sistema de gerenciamento da clínica de Quiropraxia tem como objetivo integrar práticas de desenvolvimento, testes e segurança ao longo de todo o ciclo de vida da aplicação. A abordagem busca garantir que os requisitos de segurança sejam considerados desde o planejamento até a operação do sistema, reduzindo a possibilidade de vulnerabilidades chegarem ao ambiente de produção.

O ciclo foi organizado em quatro etapas principais: Planejamento, Código, Verificação e Operação. Essas etapas são executadas de forma contínua, permitindo que alterações realizadas no sistema sejam analisadas, testadas e disponibilizadas de maneira controlada.

### 1. Planejamento

A etapa de planejamento inicia o ciclo de desenvolvimento e tem como objetivo definir o que será desenvolvido e quais requisitos de segurança deverão ser considerados. Para o sistema da clínica, são analisadas as funcionalidades relacionadas aos três perfis de usuários: Quiropraxista Majoritário, Quiropraxista e Secretária, considerando as diferentes permissões de acesso de cada perfil.

Nessa etapa são identificados os dados que necessitam de maior proteção, principalmente os dados cadastrais dos pacientes, prontuários, informações de autenticação e registros financeiros. Também são definidos requisitos relacionados à autenticação, autorização, confidencialidade, integridade e rastreabilidade das informações.

A segurança deve ser considerada desde a definição das funcionalidades. Por exemplo, ao planejar a funcionalidade de consulta de prontuários, deve-se estabelecer que somente usuários autorizados poderão acessar essas informações. Da mesma forma, o módulo financeiro deve possuir restrições de acesso de acordo com o perfil do usuário.

Também podem ser identificadas ameaças utilizando técnicas como STRIDE, permitindo antecipar riscos como acesso indevido, alteração não autorizada de dados, exposição de informações e elevação de privilégios.

Ao final dessa etapa, as funcionalidades são transformadas em tarefas de desenvolvimento, acompanhadas dos respectivos requisitos de segurança e critérios de aceitação.

### 2. Código

Na etapa de código ocorre a implementação das funcionalidades planejadas. Os desenvolvedores realizam alterações no repositório do projeto, normalmente por meio de branches e pull requests, evitando que alterações sejam inseridas diretamente na versão principal do sistema.

Durante o desenvolvimento, as práticas de desenvolvimento seguro devem ser aplicadas ao código. Como o sistema manipula dados de pacientes e informações financeiras, é importante utilizar mecanismos adequados de autenticação e autorização, validar as entradas fornecidas pelos usuários e utilizar consultas parametrizadas para evitar ataques de injeção.

As senhas não devem ser armazenadas diretamente no código ou no banco de dados em texto puro. Além disso, informações sensíveis, como credenciais de banco de dados, chaves de API e outros segredos, devem ser armazenadas utilizando mecanismos apropriados de gerenciamento de secrets, e não diretamente no repositório.

O controle de acesso também deve ser implementado nessa etapa. O sistema deve verificar não apenas se o usuário está autenticado, mas também se possui permissão para executar determinada operação. Dessa forma, um Quiropraxista, por exemplo, não deve conseguir acessar funcionalidades administrativas destinadas ao Quiropraxista Majoritário apenas manipulando requisições ou URLs.

Cada alteração realizada no código pode iniciar automaticamente o pipeline de integração contínua por meio do GitHub Actions, permitindo que as verificações sejam executadas antes que a alteração seja incorporada à aplicação.

### **3. Verificação**

A etapa de verificação é responsável por avaliar se o código desenvolvido atende aos requisitos funcionais e de segurança definidos anteriormente.

Quando um push ou pull request é realizado no GitHub, o pipeline pode executar automaticamente diferentes verificações. Inicialmente, o projeto pode ser compilado para identificar erros de construção. Em seguida, são executados os testes automatizados responsáveis por verificar o comportamento das funcionalidades.

Além dos testes funcionais, são realizadas verificações específicas de segurança. Uma ferramenta de SAST (Static Application Security Testing), como o CodeQL, pode analisar o código-fonte procurando padrões associados a vulnerabilidades. Também podem ser verificadas as dependências utilizadas pelo sistema, identificando bibliotecas que possuam vulnerabilidades conhecidas.

Outra verificação importante é a identificação de secrets expostos, evitando que senhas, tokens ou outras credenciais sejam acidentalmente inseridos no repositório. Ferramentas de secret scanning ou soluções como o Gitleaks podem ser utilizadas para essa finalidade.

Caso o sistema esteja disponível em um ambiente de testes, também pode ser realizada uma análise DAST (Dynamic Application Security Testing). Nesse caso, a aplicação é executada e submetida a testes de segurança, permitindo identificar vulnerabilidades que podem não ser encontradas apenas pela análise do código.

O fluxo de verificação pode ser representado da seguinte forma:

![fluxograma-verificacao](diagramas/fluxograma-verificacao.png)

Se alguma verificação crítica falhar, o pipeline deve impedir o avanço da alteração para as etapas seguintes. O desenvolvedor deverá corrigir o problema e realizar uma nova alteração para que as verificações sejam executadas novamente.

### 4. Operação

Após a aprovação das alterações e a conclusão das verificações, a aplicação pode ser disponibilizada em um ambiente de homologação ou produção. A etapa de operação representa o funcionamento efetivo do sistema e o acompanhamento contínuo de sua segurança e disponibilidade.

No ambiente da clínica, o sistema será responsável por processar as operações relacionadas aos pacientes, agenda, prontuários e informações financeiras. Por esse motivo, é necessário monitorar o comportamento da aplicação e identificar possíveis falhas ou atividades anormais.

Durante a operação, devem ser acompanhados eventos relacionados à autenticação, tentativas de acesso não autorizado, alterações de permissões, acesso aos prontuários e operações financeiras. Os registros de eventos (logs) podem auxiliar na identificação e investigação de incidentes.

Também devem ser realizados procedimentos de manutenção, como atualização das dependências, aplicação de correções de segurança e execução periódica de testes. Caso uma vulnerabilidade seja identificada em produção, ela deve retornar ao ciclo de desenvolvimento para análise, correção, verificação e posterior disponibilização de uma nova versão.

Dessa forma, a operação não representa o final do processo. Ela alimenta novamente a etapa de planejamento, criando um ciclo contínuo de melhoria da segurança.

### Ciclo completo

Considerando as quatro etapas, o ciclo DevSecOps do sistema pode ser representado da seguinte maneira:

![fluxograma-cicloCompleto](diagramas/fluxograma-cicloCompleto.png)                    

Assim, o pipeline DevSecOps permite que a segurança seja tratada como uma atividade contínua e integrada ao desenvolvimento do sistema. No contexto da clínica de Quiropraxia, essa abordagem é especialmente importante devido à natureza das informações armazenadas, principalmente os prontuários, dados cadastrais e registros financeiros.

O ciclo também permite estabelecer uma relação entre análise de riscos, desenvolvimento, automação de testes, segurança e operação. Dessa forma, uma vulnerabilidade identificada durante a operação pode gerar uma nova atividade de planejamento, ser corrigida no código, passar novamente pelas verificações automatizadas e somente então ser disponibilizada no ambiente de produção. Isso cria um processo contínuo de detecção, correção e prevenção de vulnerabilidades ao longo de todo o ciclo de vida do sistema.


## Condições de Parada (Break the Build): Indicar pelo menos 3 falhas que impediriam o deploy (ex: segredo no código, vulnerabilidade crítica)

## Roteiro do Vídeo Final: Estruturar a fala e os pontos de demonstração da evolução do projeto (5 a 8 minutos)
