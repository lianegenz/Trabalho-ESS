### 8.4 Registro de riscos

| ID  |  Origem STRIDE          | Evento de risco                                                                     | Vulnerabilidade ou condição                                                               | Probabilidade | Impacto | Pontuação | Nível    |
| --- | ------------------------| ------------------------------------------------------------------------------------| ----------------------------------------------------------------------------------------- | ------------- | ------- | --------- | -------- |
| R01 | Spoofing                | O atacante acessa o cadastro do usuário interno e obtem informações confidênciais   | Credenciais comprometidas e falta de verificação adicional ao acessar cadastro            | 3             | 4       | 12        | Crítico  |
| R02 | Tampering               | O banco de dados é invadido e informações são alteradas                             | Ausência de criptografia de rede ou software desatualizado                                | 2             | 4       | 8         | Alto     |
| R03 | Repudiation             | Um usuário não realiza o pagamento e afirma não ter recebido o comprovante          | Logs e registros de pagamentos não existentes ou deletados                                | 3             | 3       | 9         | Alto     |
| R04 | Information Disclosure  | O cadastro do usuário é acessado de forma não autorizada e informações são expostas | Erros na autorização de acesso e validação de registro pouco efetiva                      | 3             | 3       | 6         | Médio    | 
| R05 | Denial of Service       | O sistema fica indisponível durante o horário de funcionamento                      | Capacidade de acessos insuficiêntes e falta de limites de acesso ou verificação de acesso | 4             | 4       | 16        | Crítico  |
| R06 | Elevation of Privilege  | Um usuário interno obtem permissão de administrador indevidamente                   | Gerenciamento de permissão insuficiente ou ineficaz nas funcionalidades administrativas   | 2             | 4       | 8         | Alto     | 

### 8.5 Justificativas              

#### R01 — Acesso indevido ao cadastro de um usuário importante

A probabilidade foi classificada como média-alta porque o comprometimento de credenciais é um evento considerado frequente, principalmente quando são utilizadas credenciais muito simples e previsíveis ou fáceis de serem quebradas por injeção de software malicioso.

O impacto foi classificado como muito alto porque o atacante obtem acesso a informações sensíveis dos pacientes cadastrados no sistema, resultando na violação de privacidade de multiplos usuários.

#### R02 — Alterações não autorizadas no banco de dados

A probabilidade foi classificada como média-baixa porque as alterações dependem de falhas de segurança específicas ou um conhecimento técnico considerável.

O impacto foi classificado como muito alto porque todas as informações do sistema seriam afetadas de forma crítica, comprometendo o funcionamento geral da clínica. 

#### R03 — Negação de uma operação de pagamento

A probabilidade foi classificada como média-alta porque o problema depende da inexistência, insuficiência ou exclusão dos logs e registros relacionados aos pagamentos realizados armazenados no sistema.

O impacto foi classificado como médio-alto porque a ausência de registros pode dificultar a comprovação de pagamentos, possívelmente resultando em prejuízos e a incapacidade de contestar e provar que não houve transferência.

#### R04 — Exposição de informações do usuário interno

A probabilidade foi classificada como média-alta porque falhas de autorização ou validações inadequadas podem permitir que usuários não autorizados ou atacantes acessem informações que não deveriam estar disponíveis para seu nível de permissão.

O impacto foi classificado como médio-alto porque o acesso não autorizado pode resultar na exposição de informações confidenciais dos usuários, comprometendo a privacidade e a segurança dos dados armazenados.

#### R05 — Indisponibilidade do sistema

A probabilidade foi classificada como muito alta porque a capacidade insuficiente para suportar muitos acessos simultâneos pode causar indisponibilidade, além de ataques ou acessos excessivos poderem sobrecarregar os recursos do sistema.

O impacto foi classificado como muito alto porque a indisponibilidade pode impedir os usuários de acessar funcionalidades importantes do sistema, realizar operações dentro dos prazos estabelecidos e comprometer a continuidade dos serviços.

#### R06 — Acesso indevido a permissões administrativas

A probabilidade foi classificada como média-baixa porque a exploração depende da existência de falhas ou inconsistências no controle de permissões e na autorização das funcionalidades administrativas.

O impacto foi classificado como muito alto porque um usuário que obtenha privilégios administrativos indevidamente poderá acessar funcionalidades restritas, modificar informações importantes e alterar configurações, comprometendo a integridade e a segurança do sistema.
