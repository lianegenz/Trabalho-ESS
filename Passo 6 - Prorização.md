### 8.6 Priorização

A ordem inicial de prioridade é:

1. **R05 — Indisponibilidade do sistema:** apresentou a maior pontuação (16), sendo classificado como crítico. Esse risco pode afetar todos os usuários e impedir o acesso às principais funcionalidades do sistema durante o período de funcionamento da clínica.
2. **R01 — Acesso ao sistema utilizando a identidade de um usuário legítimo:** apresentou pontuação 12 e foi classificado como crítico. Esse acesso indevido pode permitir a realização de operações não autorizadas e comprometer informações importantes do sistema.
3. **R04 — Exposição não autorizada de informações dos pacientes:** apresentou pontuação 9 e foi classificado como alto. A exploração desse risco pode resultar na exposição de dados pessoais, prontuários e históricos de atendimentos dos pacientes.
4. **R02 — Alterações não autorizadas no banco de dados:** apresentou pontuação 8 e foi classificado como alto. Apesar de depender de condições específicas para ocorrer, uma exploração bem-sucedida pode comprometer informações importantes e afetar o funcionamento geral do sistema.
5. **R06 — Acesso indevido a permissões administrativas:** também apresentou pontuação 8 e foi classificado como alto. Sua exploração depende de falhas no controle de permissões, mas pode permitir o acesso a funcionalidades administrativas e alterações não autorizadas.
6. **R03 — Negação de uma operação de pagamento:** apresentou a menor pontuação, 6, sendo classificado como médio. Embora possa gerar prejuízos financeiros e dificuldades para comprovar pagamentos, sua ocorrência foi considerada menos provável em comparação aos demais riscos.

Os riscos R02 e R06 apresentaram a mesma pontuação. Para fins de organização, o R02 foi colocado anteriormente por apresentar potencial de impacto direto sobre uma quantidade maior de informações do sistema.


### 8.7 Conclusão da análise

A utilização do STRIDE possibilitou a identificação de diferentes ameaças ao sistema. A análise da probabilidade de ocorrência e do impacto associado demonstrou que esses riscos apresentam diferentes níveis de prioridade.

Os riscos classificados como críticos devem ser tratados inicialmente, principalmente aqueles relacionados à disponibilidade do sistema, à segurança das contas dos usuários e à proteção das informações confidenciais.

Essa classificação corresponde a uma avaliação inicial, realizada com base nas informações disponíveis sobre o sistema. Os níveis de risco poderão ser reavaliados e ajustados conforme sejam obtidos novos dados sobre o funcionamento da aplicação, os usuários, as vulnerabilidades identificadas ou eventuais incidentes registrados.
