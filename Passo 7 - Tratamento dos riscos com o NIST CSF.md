## 9. Tratamento dos riscos com o NIST CSF

Com os riscos identificados e classificados conforme sua probabilidade e impacto, nós estabelecemos ações destinadas a diminuir a possibilidade de ocorrência dos eventos ou limitar suas consequências para o sistema de agendamento.

Para estruturar essas ações, foi adotado o **NIST Cybersecurity Framework (CSF) 2.0**, que permite organizar as práticas de segurança de acordo com seis funções principais:

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
| R04 — Exposição de informações do usuário interno     | Alto    | Reduzir                    | Os dados precisam ser amazenados de maneira segura e monitorados contra ameaças                               |                                                                            
| R02 — Alterações não autorizadas no banco de dados    | Alto    | Reduzir                    | Os dados precisam estar ativos para o sistema, com maior proteção contra ataques                              |
| R06 — Acesso indevido a permissões administrativas    | Alto    | Reduzir                    | Alguns usuários necessitam de permissão administrativa mas o acesso deve requerer uma verificação mais rigída |
| R03 — Negação de uma operação de pagamento            | Médio   | Reduzir e aceitar residual | Registros armazenados que sejam confiáveis reduzem o risco, mas possíveis erros ainda podem existir           |


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

| Risco | Medidas propostas | Funções relacionadas| Responsáveis | Formas de verificação |
| --- | --- | --- | --- | --- |
| R01 — Acesso indevido ao cadastro de um administrador | Autenticação multifator; confirmação adicional para operações sensíveis; encerramento adequado das sessões; notificações sobre operações relevantes; bloqueio após tentativas suspeitas | Protect, Detect, Respond e Recover | Equipe de desenvolvimento, infraestrutura e administração do sistema | Testes de autenticação; análise dos registros de acesso; simulação de comprometimento de conta; verificação do funcionamento das notificações |
| R02 — Alterações não autorizadas no banco de dados | Validação das informações no servidor; autorização para operações de alteração; mecanismos de integridade; histórico de alterações; possibilidade de recuperação de informações anteriores | Protect, Detect, Respond e Recover | Equipe de desenvolvimento, infraestrutura e responsáveis pelos processos da clínica | Testes de autorização; análise dos históricos; tentativas controladas de alteração; testes de recuperação de dados |
| R03 — Negação de uma operação de pagamento | Registro de usuário, data, horário, origem e ação realizada; proteção dos logs contra alterações; sincronização dos horários dos servidores; política de retenção dos registros | Govern, Protect, Detect e Respond | Equipe de infraestrutura e administração do sistema | Consulta dos registros; testes de rastreabilidade; verificação da integridade dos logs; conferência da retenção das informações |
| R04 — Exposição de informações do usuário interno | Controle de acesso no servidor; princípio do menor privilégio; limitação das informações apresentadas; criptografia de dados sensíveis; monitoramento de consultas suspeitas | Protect, Detect, Respond e Recover | Desenvolvimento, infraestrutura e responsáveis pela proteção dos dados | Testes de autorização; revisão de perfis; análise de registros de acesso; tentativas controladas de consulta a dados de outros usuários |
| R05 — Indisponibilidade do sistema | Limitação de requisições; monitoramento de recursos; ampliação de capacidade; mecanismos contra tráfego malicioso; redundância; plano de contingência e comunicação de indisponibilidade | Govern, Identify, Protect, Detect, Respond e Recover | Equipe de infraestrutura, gestão interna e responsáveis pela realização de agendamentos e consultas | Testes de carga; acompanhamento da disponibilidade; simulação de sobrecarga; avaliação dos alertas; execução do plano de contingência |
| R06 — Acesso indevido a permissões administrativas | Autorização em todas as operações administrativas; princípio do menor privilégio; separação de funções; revisão periódica das permissões; autenticação reforçada para contas administrativas | Govern, Identify, Protect e Detect | Desenvolvimento, administradores do sistema e gestão interna | Testes de autorização; revisão das permissões; tentativas controladas de acesso; auditoria das contas com privilégios elevados |


### 9.5 Ordem inicial de implementação

Considerando a pontuação e a prioridade estabelecidas na análise de riscos, recomenda-se a seguinte ordem para implantação das medidas:

1. **Fortalecer os mecanismos de autorização**, principalmente nas funcionalidades de cadastro e administrativas, reduzindo os riscos R02, R04 e R06.
2. **Aumentar a proteção das contas dos usuários**, especialmente para operações que possam gerar consequências médicas relevantes, tratando o risco R01.
3. **Implementar mecanismos confiáveis de registro e monitoramento**, contribuindo para a identificação e investigação dos riscos R01, R02, R03, R04 e R06.
4. **Aumentar a capacidade e a disponibilidade do site durante períodos de atendimento**, priorizando o tratamento do risco R05.
5. **Estabelecer procedimentos de resposta e recuperação**, permitindo que a gestão reaja de maneira organizada diante de incidentes.
6. **Reavaliar periodicamente os riscos**, verificando se as medidas adotadas continuam adequadas diante de alterações no site, nos usuários ou no ambiente profissional.



### 9.6 Estimativa do risco residual

A implementação dos controles tende a reduzir a exposição aos riscos identificados. A tabela abaixo apresenta uma estimativa do nível que poderá ser alcançado após a aplicação e validação das medidas propostas.

| Risco |	Nível inicial |	Nível residual estimado |	Critério para aceitação do risco residual |
| --- | --- | --- | --- |
| R01 |	Crítico |	Médio |	Autenticação reforçada, alertas de operações sensíveis e mecanismos de recuperação da conta funcionando adequadamente.  |
| R02 |	Alto    |	Baixo |	Autorizações, validações de integridade e histórico de alterações comprovados por testes.                               |
| R03 |	Médio   |	Baixo |	Registros completos, protegidos contra alterações e disponíveis para auditoria e investigação.                          |
| R04 |	Alto    |	Médio |	Restrições de acesso, princípio do menor privilégio, proteção das informações e monitoramento implementados.            |
| R05 |	Crítico |	Alto  |	Testes de capacidade realizados, mecanismos de monitoramento ativos e plano de contingência validado.                   |
| R06 |	Alto    |	Baixo |	Permissões administrativas devidamente restritas, revisadas e protegidas por autenticação reforçada.                    |

Os níveis residuais apresentados são apenas estimativas e precisam ser confirmados por evidências obtidas durante os testes e o monitoramento do sistema. Caso os controles implementados não apresentem a eficácia esperada, os riscos deverão ser novamente analisados e poderão ser necessárias medidas complementares.


### 9.7 Conclusão do tratamento

A análise de prioridade permitiu identificar quais ameaças devem receber maior atenção durante o desenvolvimento e a operação do sistema. A utilização do NIST CSF possibilitou organizar as medidas de segurança de acordo com as funções Govern, Identify, Protect, Detect, Respond e Recover, proporcionando uma visão mais abrangente do tratamento dos riscos.

As ações propostas combinam mecanismos técnicos, regras de acesso, responsabilidades profissionais, registros de auditoria, monitoramento, procedimentos de resposta e estratégias de recuperação. Dessa forma, a proteção do sistema não fica limitada à prevenção, contemplando também a identificação e o tratamento dos incidentes quando eles ocorrerem.

Os controles definidos nesta etapa ainda precisam ser incorporados à arquitetura da aplicação, implementados e submetidos a testes. A efetividade das medidas somente poderá ser confirmada mediante evidências obtidas durante essas verificações. A partir dos resultados, os riscos residuais poderão ser novamente avaliados e, quando apropriado, formalmente aceitos pelos responsáveis.
