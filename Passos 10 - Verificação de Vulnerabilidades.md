### Configuração do Ambiente e Ferramenta

### Análise de Alertas e Achados

### Propostas de Correção
Com base nos riscos identificados nas etapas anteriores, são propostas medidas de correção e prevenção para reduzir possíveis vulnerabilidades e aumentar a segurança do sistema.

**Acesso indevido e credenciais**
Para reduzir o risco de acesso não autorizado, deverão ser utilizadas contas individuais, armazenamento seguro das senhas e limitação de tentativas de login. Após a autenticação, o sistema deverá verificar as permissões do usuário antes de liberar o acesso às funcionalidades.

**Controle de acesso e permissões**
Os perfis **Quiropraxista Majoritário, Quiropraxista** e **Secretária** deverão possuir permissões de acordo com suas funções.
O **Quiropraxista Majoritário** terá acesso a todas as funcionalidades disponíveis ao Quiropraxista, além de permissões administrativas adicionais. Dessa forma, cada usuário terá acesso somente às informações e funcionalidades autorizadas para seu perfil.

**Proteção do banco de dados**
O banco de dados deverá ser acessado somente por meio da aplicação, com validação das informações inseridas e controle das permissões de acesso. Os componentes utilizados pelo sistema também deverão ser mantidos atualizados.
Proteção dos dados dos pacientes
O acesso aos dados cadastrais e aos prontuários deverá ser restrito aos usuários autorizados. Consultas e alterações importantes deverão ser registradas, permitindo identificar o usuário responsável pela ação.

**Registros financeiros**
Pagamentos e outras movimentações financeiras deverão possuir registros de auditoria, permitindo identificar quem realizou ou alterou determinada operação e reduzindo a possibilidade de alterações ou negações indevidas.

**Disponibilidade do sistema**
Para reduzir o risco de indisponibilidade, deverão ser adotados mecanismos de controle de acessos excessivos, monitoramento do funcionamento da aplicação e procedimentos de backup e recuperação dos dados.
Após a aplicação das correções, os testes de segurança deverão ser executados novamente para verificar se os problemas identificados foram corrigidos ou se os riscos foram reduzidos.

