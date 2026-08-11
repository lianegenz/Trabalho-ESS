## 9. Tratamento dos riscos com o NIST CSF

Com os riscos identificados e classificados conforme sua probabilidade e impacto, nós estabelecemos ações destinadas a diminuir a possibilidade de ocorrência dos eventos ou limitar suas consequências para o sistema acadêmico.

Para estruturar essas ações, foi adotado o NIST Cybersecurity Framework (CSF) 2.0, que permite organizar as práticas de segurança de acordo com seis funções principais:

| Função | Aplicação no sistema |
| --- | --- |
| Govern    | Estabelecer responsabilidades, regras de segurança, prioridades e critérios para gerenciamento dos riscos. |
| Identify  | Levantar ativos, informações, usuários, dependências, vulnerabilidades e riscos relacionados ao sistema. |
| Protect   | Aplicar mecanismos preventivos para dificultar a ocorrência de incidentes e reduzir seus possíveis danos. |
| Detect    | Reconhecer comportamentos anormais, tentativas de acesso indevido e outros sinais de incidentes. |
| Respond   | Definir ações para analisar, conter, comunicar e controlar incidentes de segurança. |
| Recover   | Restabelecer serviços, informações e operações após incidentes, reduzindo os efeitos provocados pela interrupção. |

As funções do NIST CSF servem como referência para organizar os objetivos de segurança, não sendo obrigatório associá-las a uma tecnologia específica. Dessa forma, os mecanismos apresentados nesta seção correspondem às medidas consideradas mais adequadas para o sistema de agendamento analisado.


### 9.1 Estratégias de tratamento

Para definir como cada risco será conduzido, foram consideradas quatro possibilidades de tratamento:

| Estratégia | Aplicação |
| --- | --- |
| Evitar       | Retirar ou modificar a atividade que possibilita a ocorrência do risco.                                |
| Reduzir      | Adotar controles capazes de diminuir a chance de ocorrência ou limitar os efeitos do incidente.        |
| Compartilhar | Transferir parte das responsabilidades, operações ou consequências para serviços ou entidades externas.|
| Aceitar      | Manter o risco de forma consciente, desde que ele esteja documentado, justificado e acompanhado.       |

A decisão de aceitar um risco não representa a ausência de medidas de segurança. O risco residual precisa ser conhecido pelos responsáveis, possuir uma justificativa e ser acompanhado ao longo do tempo.


### 9.2 Estratégia escolhida para cada risco

| Risco | Nível inicial | Estratégia principal | Justificativa |
| --- | --- | --- | --- |
| R05 — Indisponibilidade do sistema                    | Crítico | Reduzir e compartilhar     | A clínica pode utilizar serviços externos de verificação de bots ao acessar o site                            |
| R01 — Acesso indevido ao cadastro de um administrador | Crítico | Reduzir                    | O cadastro precisa estar ativo, podendo receber outras camadas de autênticação                                | 
| R04 — Exposição de informações do usuário interno     | Alto    | Reduzir                    | Os dados precisam ser amazenados de maneira segura e monitorados contra ameaças                               |                                                                                                              |
| R02 — Alterações não autorizadas no banco de dados    | Alto    | Reduzir                    | Os dados precisam estar ativos para o sistema, com maior proteção contra ataques                              |
| R06 — Acesso indevido a permissões administrativas    | Alto    | Reduzir                    | Alguns usuários necessitam de permissão administrativa mas o acesso deve requerer uma verificação mais rigída |
| R03 — Negação de uma operação de pagamento            | Médio   | Reduzir e aceitar residual | Registros armazenados que sejam confiáveis reduzem o risco, mas possíveis erros ainda existiriam              |


### 9.3 Mapeamento dos riscos para as funções do NIST CSF

| Risco | Govern | Identify | Protect | Detect | Respond | Recover |
| --- | :---: | :---: | :---: | :---: | :---: | :---: |
| R01 — Acesso indevido ao cadastro de um administrador  | X | X | X | X | X | X |
| R02 — Alterações não autorizadas no banco de dados     | X | X | X | X | X | X |
| R03 — Negação de uma operação de pagamento             | X |  | X | X | X |  |
| R04 — Exposição de informações do usuário interno      | X | X | X | X | X | X |
| R05 — Indisponibilidade do sistema                     | X | X | X | X | X | X |
| R06 — Acesso indevido a permissões administrativas     | X | X | X | X | X |  |

A associação apresentada indica quais funções do NIST CSF devem ser consideradas no tratamento de cada ameaça. Isso não significa que todas as funções terão o mesmo peso ou exigirão a mesma quantidade de mecanismos de segurança.

### 9.4 Plano de tratamento dos riscos


### 9.5 Ordem inicial de implementação



### 9.6 Estimativa do risco residual


### 9.7 Conclusão do tratamento


### 9.6 Estimativa do risco residual
