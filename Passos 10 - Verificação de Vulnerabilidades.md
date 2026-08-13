### Configuração do Ambiente e Ferramenta

### Análise de Alertas e Achados

**T01 — Spoofing: comprometimento de credenciais**

Foi identificado como achado de segurança o risco de comprometimento das credenciais utilizadas pelos usuários do sistema. A vulnerabilidade está relacionada à possibilidade de obtenção de credenciais por meio de phishing, reutilização de senhas ou armazenamento e transmissão inadequados dessas informações. Também foi considerada a possibilidade de mecanismos de autenticação insuficientes permitirem tentativas repetidas de acesso. A exploração dessa vulnerabilidade poderia permitir que um atacante assumisse a identidade de um quiropraxista ou da secretária e realizasse operações utilizando uma conta legítima. Dessa forma, o achado foi considerado relevante por comprometer a autenticidade dos usuários e possibilitar acesso indevido às funcionalidades e informações do sistema.

**T02 — Tampering: alteração indevida de informações**

O processo de análise identificou como achado a possibilidade de alteração indevida dos dados armazenados pelo sistema. A vulnerabilidade está associada à validação insuficiente das informações fornecidas pelos usuários e ao controle inadequado das permissões de acesso ao banco de dados. Caso um usuário ou atacante consiga explorar essa condição, poderá modificar ou excluir informações relacionadas aos pacientes, agendamentos, usuários, procedimentos e registros financeiros. O impacto está relacionado principalmente à perda da integridade dos dados, podendo provocar erros nos atendimentos, desorganização da agenda, inconsistências financeiras e comprometimento dos registros dos pacientes.

**T03 — Repudiation: ausência de rastreabilidade das operações**

Foi identificado um achado relacionado à possibilidade de o sistema não possuir registros suficientes para comprovar determinadas operações realizadas pelos usuários. A vulnerabilidade decorre da ausência ou insuficiência de mecanismos de auditoria e da possibilidade de os logs serem incompletos, alterados ou excluídos. Em uma situação de contestação de pagamento ou de alteração de informações de um paciente, por exemplo, pode não ser possível determinar com precisão quem realizou a operação, quando ela ocorreu ou qual informação foi modificada. Esse cenário dificulta a responsabilização dos usuários e a investigação de incidentes, comprometendo a rastreabilidade e a confiabilidade das informações registradas.

**T04 — Information Disclosure: exposição de dados dos pacientes**

A análise identificou como achado a possibilidade de acesso indevido aos dados pessoais e informações de saúde dos pacientes. As vulnerabilidades relacionadas incluem controles inadequados de acesso aos prontuários e proteção insuficiente dos dados armazenados. Caso um usuário sem autorização consiga consultar essas informações, poderá ter acesso ao histórico médico, dados cadastrais, informações de consultas e outros dados sensíveis. O impacto é considerado relevante devido à violação da confidencialidade e da privacidade dos pacientes, além das possíveis consequências legais e administrativas decorrentes da exposição dessas informações.

**T05 — Denial of Service: indisponibilidade do sistema**

Foi identificado como achado o risco de indisponibilidade do portal web e dos mecanismos de autenticação diante de uma grande quantidade de solicitações simultâneas. A vulnerabilidade está relacionada à ausência ou insuficiência de mecanismos capazes de limitar requisições e controlar tentativas excessivas de autenticação. Um atacante poderia explorar essa condição enviando uma quantidade elevada de solicitações, consumindo os recursos disponíveis do sistema. Como consequência, o portal poderia apresentar lentidão ou ficar indisponível, impedindo que pacientes e profissionais realizassem operações como consultas, agendamentos ou acesso às informações necessárias para o funcionamento da clínica.

**T06 — Elevation of Privilege: obtenção indevida de permissões**

A análise identificou como achado a possibilidade de um usuário obter permissões superiores às previstas para seu perfil. As vulnerabilidades relacionadas incluem falhas no controle de autorização, permissões excessivas, ausência de validação das permissões no servidor e segregação inadequada entre os perfis de quiropraxista majoritário, quiropraxista e secretária. A exploração dessa condição poderia permitir que um usuário executasse operações que não fazem parte de suas responsabilidades, como alterar dados de pacientes, modificar agendamentos, acessar informações financeiras ou alterar permissões de outros usuários. O impacto pode ser elevado, pois o comprometimento de uma conta com privilégios indevidos pode afetar diferentes áreas do sistema simultaneamente.

**Síntese da análise**

De maneira geral, os achados identificados demonstram que os principais pontos de atenção do sistema estão relacionados à autenticação, autorização, proteção de dados, integridade das informações, rastreabilidade das operações e disponibilidade do serviço. A análise permitiu relacionar as ameaças identificadas pelo STRIDE às vulnerabilidades presentes na arquitetura do sistema.


### Propostas de Correção
Com base nos riscos identificados nas etapas anteriores, são propostas medidas de correção e prevenção para reduzir possíveis vulnerabilidades e aumentar a segurança do sistema.

**Acesso indevido e credenciais**
Para reduzir o risco de acesso não autorizado, deverão ser utilizadas contas individuais, armazenamento seguro das senhas e limitação de tentativas de login. Após a autenticação, o sistema deverá verificar as permissões do usuário antes de liberar o acesso às funcionalidades.

**Controle de acesso e permissões**
Os perfis **Quiropraxista Majoritário, Quiropraxista** e **Secretária** deverão possuir permissões de acordo com suas funções.
O **Quiropraxista Majoritário** terá acesso a todas as funcionalidades disponíveis ao Quiropraxista, além de permissões administrativas adicionais. Dessa forma, cada usuário terá acesso somente às informações e funcionalidades autorizadas para seu perfil.

**Proteção do banco de dados**
O banco de dados deverá ser acessado somente por meio da aplicação, com validação das informações inseridas e controle das permissões de acesso. Os componentes utilizados pelo sistema também deverão ser mantidos atualizados.

**Proteção dos dados dos pacientes**
O acesso aos dados cadastrais e aos prontuários deverá ser restrito aos usuários autorizados. Consultas e alterações importantes deverão ser registradas, permitindo identificar o usuário responsável pela ação.

**Registros financeiros**
Pagamentos e outras movimentações financeiras deverão possuir registros de auditoria, permitindo identificar quem realizou ou alterou determinada operação e reduzindo a possibilidade de alterações ou negações indevidas.

**Disponibilidade do sistema**
Para reduzir o risco de indisponibilidade, deverão ser adotados mecanismos de controle de acessos excessivos, monitoramento do funcionamento da aplicação e procedimentos de backup e recuperação dos dados.
Após a aplicação das correções, os testes de segurança deverão ser executados novamente para verificar se os problemas identificados foram corrigidos ou se os riscos foram reduzidos.

