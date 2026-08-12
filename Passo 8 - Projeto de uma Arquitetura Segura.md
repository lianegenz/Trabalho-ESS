### Requisitos de Segurança

### Vulnerabilidades Catalogadas

### Decisões de Arquitetura
As decisões de arquitetura do sistema foram definidas considerando a necessidade de proteger os dados dos pacientes, os prontuários, as informações financeiras e as credenciais dos usuários. Como o sistema possui diferentes perfis de acesso e trabalha com informações que não devem estar disponíveis igualmente para todos os usuários, a arquitetura foi organizada de forma a limitar acessos, registrar ações importantes e reduzir a possibilidade de alterações ou consultas indevidas.

### Controle de acesso por perfil

O sistema utilizará controle de acesso baseado nos perfis Quiropraxista Majoritário, Quiropraxista e Secretária.

O Quiropraxista Majoritário terá acesso administrativo mais amplo, incluindo gerenciamento de usuários, permissões, prontuários e informações financeiras.

O Quiropraxista terá acesso às funcionalidades relacionadas aos atendimentos, pacientes, agenda e prontuários.

A Secretária terá acesso às atividades administrativas, como cadastro de pacientes, organização da agenda e registros financeiros permitidos ao seu perfil.

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
