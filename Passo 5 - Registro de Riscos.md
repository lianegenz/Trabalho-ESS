### 8.4 Registro de riscos

| ID  |  Origem STRIDE          | Evento de risco                                                                     | Vulnerabilidade ou condição                                                               | Probabilidade | Impacto | Pontuação | Nível    |
| --- | ------------------------| ------------------------------------------------------------------------------------| ----------------------------------------------------------------------------------------- | ------------- | ------- | --------- | -------- |
| R01 | Spoofing                | O atacante utiliza credenciais comprometidas para acessar o sistema se passando por um usuário legítimo  | Credenciais comprometidas e falta de verificação adicional ao acessar cadastro            | 3             | 4       | 12        | Crítico  |
| R02 | Tampering               | O atacante consegue alterar informações armazenadas no banco de dados sem autorização  | Falhas na validação e parametrização das entradas, permitindo a exploração de SQL Injection e alterações não autorizadas no banco de dados     | 2             | 4       | 8         | Alto     |
| R03 | Repudiation             | Um usuário não realiza o pagamento e afirma não ter recebido o comprovante          | Logs e registros de pagamentos insuficientes, inconsistentes ou não armazenados de forma confiável  | 2             | 3       | 6         | Médio    |
| R04 | Information Disclosure  | Um usuário não autorizado acessa prontuários, dados pessoais e histórico de atendimentos dos pacientes | Erros na autorização de acesso e validação de registro pouco efetiva                      | 3             | 3       | 9         | Alto     | 
| R05 | Denial of Service       | O sistema fica indisponível durante o horário de funcionamento                      | Capacidade insuficiente de acessos simultâneos e falta de limites de acesso ou verificação de acesso | 4             | 4       | 16        | Crítico  |
| R06 | Elevation of Privilege  | Um usuário obtém permissão de administrador indevidamente | Gerenciamento de permissão insuficiente ou ineficaz nas funcionalidades administrativas   | 2             | 4       | 8         | Alto     | 

### 8.5 Justificativas              

#### R01 — Acesso indevido ao cadastro de um usuário legítimo

A probabilidade foi classificada como média-alta porque é possível que as credenciais de um usuário sejam descobertas ou roubadas. Esse risco pode ser maior quando o sistema utiliza apenas usuário e senha e não possui outras formas de proteção.

O impacto foi classificado como muito alto porque o atacante pode utilizar a identidade de um usuário legítimo para realizar operações não autorizadas, podendo comprometer informações e funcionalidades importantes do sistema.

#### R02 — Alterações não autorizadas no banco de dados

A probabilidade foi classificada como média-baixa porque as alterações dependem de falhas de segurança específicas ou de um conhecimento técnico considerável.

O impacto foi classificado como muito alto porque todas as informações do sistema seriam afetadas de forma crítica, comprometendo o funcionamento geral da clínica. 

#### R03 — Negação de uma operação de pagamento

A probabilidade foi classificada como média-baixa porque o problema depende da inexistência, insuficiência ou exclusão dos logs e registros relacionados aos pagamentos realizados armazenados no sistema, sendo um acontecimento incomum.

O impacto foi classificado como médio-alto porque a ausência de registros pode dificultar a comprovação de pagamentos, possivelmente resultando em prejuízos financeiros para a clínica.

#### R04 — Exposição não autorizada de informações dos pacientes

A probabilidade foi classificada como média-alta porque falhas de autorização ou validações inadequadas podem permitir que usuários não autorizados ou atacantes acessem informações que não deveriam estar disponíveis para seu nível de permissão.

O impacto foi classificado como médio-alto porque o acesso não autorizado pode resultar na exposição de informações confidenciais dos pacientes, comprometendo a privacidade e a segurança dos dados armazenados.

#### R05 — Indisponibilidade do sistema

A probabilidade foi classificada como alta porque ataques ou uma quantidade elevada de acessos simultâneos podem sobrecarregar os recursos disponíveis do sistema.

O impacto foi classificado como muito alto porque a indisponibilidade pode impedir os usuários de acessar funcionalidades importantes do sistema, realizar operações dentro dos prazos estabelecidos e comprometer a continuidade dos serviços.

#### R06 — Acesso indevido a permissões administrativas

A probabilidade foi classificada como média-baixa porque a exploração depende da existência de falhas ou inconsistências no controle de permissões e na autorização das funcionalidades administrativas.

O impacto foi classificado como muito alto porque um usuário que obtenha privilégios administrativos indevidamente poderá acessar funcionalidades administrativas que não fazem parte de suas permissões, modificar informações importantes e alterar configurações, comprometendo a integridade e a segurança do sistema.
