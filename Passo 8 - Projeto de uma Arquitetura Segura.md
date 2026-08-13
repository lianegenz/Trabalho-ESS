### Requisitos de Segurança
Os requisitos de segurança foram definidos com base nas ameaças identificadas na modelagem STRIDE e nos riscos avaliados anteriormente. O objetivo é estabelecer medidas que protejam os dados dos pacientes, os prontuários, as informações financeiras e as contas dos usuários.

**RS01 — Autenticação dos usuários**

O sistema deverá exigir autenticação para permitir o acesso às funcionalidades internas. Cada usuário deverá possuir uma conta individual, não sendo permitido o compartilhamento de credenciais devido as suas permissões.

**RS02 — Controle de acesso por perfil**

O sistema deverá controlar o acesso às funcionalidades de acordo com o perfil do usuário: Quiropraxista Majoritário, Quiropraxista e Secretária. Um usuário não poderá acessar funcionalidades que não estejam relacionadas às suas permissões.

**RS03 — Proteção das senhas**

As senhas dos usuários não deverão ser armazenadas diretamente no banco de dados. O sistema deverá utilizar um mecanismo seguro de hash de senhas para impedir que elas sejam recuperadas em caso de acesso indevido ao banco de dados.

**RS04 — Autorização das operações**

O sistema deverá verificar as permissões do usuário antes de executar operações importantes, como alteração de prontuários, gerenciamento de usuários, alterações financeiras e modificações de agendamentos.

**RS05 — Proteção dos prontuários**

O acesso aos prontuários deverá ser restrito aos usuários autorizados. O sistema deverá impedir que usuários visualizem ou alterem informações que não estejam disponíveis para seu perfil.

**RS06 — Proteção das informações financeiras**

As informações relacionadas aos pagamentos e registros financeiros deverão possuir controle de acesso, permitindo que somente usuários autorizados realizem consultas ou alterações.

**RS07 — Registro de atividades**

O sistema deverá registrar operações importantes realizadas pelos usuários, incluindo acessos, alterações de prontuários, alterações financeiras, mudanças de permissões e alterações de agendamentos.

**RS08 — Validação das entradas**

Os dados fornecidos pelos usuários deverão ser validados antes de serem processados ou armazenados. A aplicação deverá verificar formato, tamanho e conteúdo dos dados para reduzir riscos de entradas maliciosas ou inválidas.

**RS09 — Proteção contra SQL Injection**

As consultas realizadas ao banco de dados deverão utilizar mecanismos seguros, como Prepared Statements ou consultas parametrizadas, evitando que dados fornecidos pelos usuários sejam interpretados como comandos SQL.

**RS10 — Comunicação segura**

A comunicação entre os usuários e o sistema deverá utilizar HTTPS, protegendo credenciais e informações transmitidas entre o navegador e o servidor.

**RS11 — Controle de sessão**

O sistema deverá controlar as sessões dos usuários autenticados, permitindo o encerramento da sessão e evitando que uma sessão permaneça ativa por tempo indefinido.

**RS12 — Proteção contra tentativas excessivas de login**

O sistema deverá limitar tentativas consecutivas de autenticação para reduzir o risco de ataques de tentativa e erro contra as contas dos usuários.

**RS13 — Backup e recuperação**

O sistema deverá possuir mecanismos de backup periódico das informações importantes, incluindo pacientes, prontuários, agendamentos e registros financeiros, permitindo a recuperação dos dados em caso de falha ou perda. Esses backups armazenados de maneiras segura.

**RS14 — Auditoria das operações**

As operações consideradas críticas deverão possuir informações suficientes para identificar qual usuário realizou a ação, quando ela ocorreu e qual operação foi realizada. Esses registros deverão ser protegidos contra alterações não autorizadas.

**RS15 — Princípio do menor privilégio**

Cada usuário deverá possuir somente as permissões necessárias para realizar suas atividades dentro do sistema. Permissões administrativas deverão ser concedidas somente aos usuários que realmente necessitem delas.

### Vulnerabilidades Catalogadas

**V01 — Proteção insuficiente da autenticação**

Os mecanismos de autenticação podem apresentar proteção insuficiente contra tentativas de acesso indevidas, devido à ausência ou fragilidade de políticas de senha, mecanismos de bloqueio, proteção contra tentativas repetidas ou outros controles de autenticação.

**Possível impacto:** Um atacante pode obter acesso indevido às contas de quiropraxistas ou da secretária, utilizando-as para realizar operações em nome de usuários legítimos.

**V02 — Exposição ou comprometimento de credenciais**

Credenciais de acesso podem ser obtidas por phishing, reutilização de senhas, compartilhamento indevido ou armazenamento e transmissão inadequados de informações de autenticação.

**Possível impacto:** Um atacante pode assumir a identidade de um usuário legítimo e acessar informações ou funcionalidades disponíveis para a conta comprometida.

**V03 — Validação insuficiente dos dados**

Dados fornecidos pelos usuários podem ser processados ou armazenados sem validação adequada de formato, conteúdo, tamanho ou consistência, permitindo a inserção de informações indevidas no sistema.

**Possível impacto:** Dados de pacientes, agendamentos, registros financeiros ou outras informações podem ser alterados de maneira indevida, provocando inconsistências e comprometendo a integridade das informações.

**V04 — Controle inadequado de alterações no banco de dados**

Usuários ou componentes da aplicação podem possuir permissões superiores às necessárias para consultar, alterar ou excluir informações diretamente no banco de dados.

**Possível impacto:** Um usuário ou atacante que obtenha acesso indevido pode modificar ou excluir dados de pacientes, agendamentos, usuários, procedimentos e registros financeiros.

**V05 — Ausência de trilha de auditoria adequada**

Operações relevantes podem não ser registradas de maneira suficiente para identificar o usuário responsável, a ação executada, o recurso afetado, a data e o horário da operação.

**Possível impacto:** O sistema pode não conseguir determinar quem realizou determinada operação, dificultando a responsabilização de usuários e a investigação de incidentes ou contestações.

**V06 — Logs insuficientes ou vulneráveis à manipulação**

Registros de eventos e operações podem não possuir mecanismos suficientes de proteção contra alteração, exclusão ou perda, permitindo que informações relevantes para auditoria sejam modificadas ou deixem de estar disponíveis.

**Possível impacto:** Evidências relacionadas a acessos, alterações de dados e operações financeiras podem ser perdidas ou comprometidas, dificultando a investigação e a comprovação dos eventos ocorridos.

**V07 — Exposição indevida de dados dos pacientes**

Informações pessoais e de saúde dos pacientes podem ser disponibilizadas a usuários ou componentes que não possuem necessidade ou autorização para acessá-las.

**Possível impacto:** Pode ocorrer exposição de dados pessoais, informações de saúde, histórico de atendimentos e outros dados sensíveis, causando violação de privacidade e possíveis consequências legais e administrativas.

**V08 — Controle inadequado de acesso aos prontuários**

Os mecanismos de controle de acesso podem não restringir adequadamente quais usuários podem consultar, alterar ou visualizar os prontuários e informações clínicas dos pacientes.

**Possível impacto:** Usuários não autorizados podem acessar informações médicas e pessoais dos pacientes, comprometendo a confidencialidade dos prontuários.

**V09 — Proteção insuficiente dos dados armazenados**

Dados pessoais, clínicos, financeiros ou de autenticação podem ser armazenados sem mecanismos adequados de proteção, tornando essas informações mais suscetíveis à exposição caso o banco de dados ou outro componente de armazenamento seja comprometido.

**Possível impacto:** Um atacante que obtenha acesso ao armazenamento pode acessar grandes quantidades de informações sensíveis, incluindo dados de pacientes e registros financeiros.

**V10 — Ausência de limitação de requisições**

O portal web pode aceitar uma quantidade excessiva de requisições sem mecanismos suficientes para limitar ou controlar solicitações provenientes de um mesmo usuário, endereço ou origem.

**Possível impacto:** Um atacante pode enviar grande quantidade de solicitações simultâneas, consumindo recursos do sistema e provocando lentidão ou indisponibilidade do serviço.

**V11 — Proteção insuficiente contra tentativas excessivas de autenticação**

O mecanismo de autenticação pode permitir sucessivas tentativas de login sem restrições suficientes, possibilitando o envio automatizado de grande quantidade de solicitações.

**Possível impacto:** O sistema pode sofrer sobrecarga e ficar indisponível, além de ficar mais suscetível a tentativas automatizadas de descoberta de credenciais.

**V12 — Falha no controle de autorização**

O sistema pode não verificar adequadamente se o usuário possui autorização para executar determinada operação, permitindo que requisições sejam realizadas mesmo quando o perfil do usuário não possui a permissão correspondente.

**Possível impacto:** Um usuário pode acessar funcionalidades administrativas ou executar operações não autorizadas, como alterar pacientes, agendamentos, registros financeiros ou procedimentos.

**V13 — Permissões excessivas para usuários**

Contas de usuários podem receber permissões superiores às necessárias para suas atividades, permitindo acesso a funcionalidades ou informações que não fazem parte de suas responsabilidades.

**Possível impacto:** O comprometimento de uma conta pode proporcionar ao atacante acesso a uma quantidade maior de informações e funcionalidades, aumentando o impacto de um incidente.

**V14 — Ausência de validação de autorização no servidor**

Restrições de acesso podem depender exclusivamente de elementos apresentados na interface do sistema, sem que o servidor valide adequadamente as permissões associadas a cada requisição.

**Possível impacto:** Um usuário pode manipular diretamente requisições e acessar funcionalidades ou recursos administrativos que deveriam estar restritos ao seu perfil.

**V15 — Segregação inadequada entre perfis de usuários**

Os perfis de quiropraxista majoritário, quiropraxista e secretária podem não possuir separação suficiente de permissões, permitindo que usuários executem operações incompatíveis com suas responsabilidades.

**Possível impacto:** Um usuário pode acessar, modificar ou excluir informações e executar operações administrativas, financeiras ou clínicas que deveriam estar restritas a outros perfis.

### Decisões de Arquitetura
As decisões de arquitetura do sistema foram definidas considerando a necessidade de proteger os dados dos pacientes, os prontuários, as informações financeiras e as credenciais dos usuários. Como o sistema possui diferentes perfis de acesso e trabalha com informações que não devem estar disponíveis igualmente para todos os usuários, a arquitetura foi organizada de forma a limitar acessos, registrar ações importantes e reduzir a possibilidade de alterações ou consultas indevidas.

### Controle de acesso por perfil

O sistema utilizará controle de acesso baseado nos perfis **Quiropraxista Majoritário, Quiropraxista e Secretária**.

O **Quiropraxista Majoritário** terá acesso a todas as funcionalidades atribuídas ao Quiropraxista, além de permissões administrativas adicionais, como gerenciamento de usuários, permissões de acesso e informações financeiras.

O **Quiropraxista** terá acesso às funcionalidades relacionadas aos atendimentos, pacientes, agenda e prontuários.

A **Secretária** terá acesso às atividades de apoio administrativo, como cadastro de pacientes, organização da agenda e registros financeiros permitidos ao seu perfil.

Essa separação reduz o risco de acesso indevido a informações que não são necessárias para cada função.

### Autenticação dos usuários

Todos os usuários deverão realizar login por meio de contas individuais. Após a autenticação, o sistema identificará o perfil do usuário e verificará suas permissões antes de liberar o acesso às funcionalidades.

As senhas deverão ser armazenadas de forma segura, sem permanecer em formato legível no banco de dados.

### Separação das funcionalidades

As principais funcionalidades serão organizadas em módulos:

autenticação e controle de acesso;
gerenciamento de usuários;
pacientes e agenda;
prontuários;
controle financeiro.

Essa separação facilita o controle das permissões e a proteção das informações.

### Proteção dos prontuários

Os prontuários contêm informações relacionadas às avaliações e aos procedimentos realizados nos pacientes. Por isso, o acesso será restrito aos usuários autorizados.

Alterações nos prontuários deverão ser registradas, permitindo identificar qual usuário realizou a ação.

### Proteção das informações financeiras

As informações financeiras terão acesso controlado por perfil. Somente usuários autorizados poderão registrar ou consultar pagamentos e movimentações.

Alterações importantes também deverão ser registradas para facilitar a identificação de possíveis inconsistências.

### Registro de ações e auditoria

O sistema deverá registrar ações importantes, como:

login e tentativas de acesso não autorizado;
alterações de usuários e permissões;
inclusão ou alteração de prontuários;
alterações de informações financeiras;
cancelamentos e alterações de atendimentos.

Esses registros permitirão identificar posteriormente quem realizou determinada operação.

### Validação dos dados

Os dados deverão ser validados antes de serem armazenados ou processados, principalmente em cadastros, prontuários, agendamentos e registros financeiros.

Essa medida reduz a possibilidade de informações inválidas ou inadequadas serem processadas pelo sistema.

### Comunicação segura

A comunicação entre os usuários e o sistema deverá utilizar conexão segura para proteger credenciais, dados dos pacientes, prontuários e informações financeiras.

Caso sejam utilizadas APIs ou serviços externos futuramente, essas comunicações também deverão ser protegidas.

### Banco de dados

O banco de dados não deverá ser acessado diretamente pelos usuários. As consultas e alterações deverão ocorrer por meio da aplicação, que verificará a identidade e as permissões antes de executar cada operação.

### Backup e recuperação dos dados

O sistema deverá realizar backups periódicos dos dados importantes, como prontuários, pacientes, agenda e registros financeiros.

Essas cópias permitirão recuperar as informações em situações de falha ou perda de dados.

### Princípio do menor privilégio

A arquitetura seguirá o princípio do menor privilégio, garantindo que cada usuário tenha somente as permissões necessárias para realizar suas atividades.

Com essas decisões, busca-se reduzir riscos relacionados ao acesso indevido, alteração de informações, exposição de dados e uso inadequado de permissões.


### Diagrama
