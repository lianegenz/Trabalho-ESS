### 8.6 Priorização

A ordem inicial de prioridade é:

1. **R05 — Indisponibilidade do sistema:** por ser um risco frequente e que afeta a maior parte dos usuário, foi considerado o registro com a maior pontuação.
2. **R01 — Acesso indevido ao cadastro de um usuário importante:** resulta na exposição e violação de privacidade de uma grande quantidade de usuários.
3. **R04 — Exposição de informações do usuário interno:** resulta na exposição de informações sensíveis de um usuário específico
4. **R02 — Alterações não autorizadas no banco de dados:** é necessario um conhecimento considerável, mas caso seja efetuado, o sistema seria afetado de forma crítica.
5. **R06 — Acesso indevido a permissões administrativas:** seria preciso haver falhas visíveis e de fácil alteração para que o sistema fosse afetado.
6. **R03 — Negação de uma operação de pagamento:** indica uma falha considerável nos registros do sistema, além de afetar questões financeiras, porem o incidente seria pouco provável.




### 8.7 Conclusão da análise

A utilização do STRIDE possibilitou a identificação de diferentes ameaças ao sistema. Entretanto, a análise da probabilidade de ocorrência e do impacto associado demonstrou que esses riscos apresentam diferentes níveis de prioridade.

Os riscos classificados como críticos devem ser tratados inicialmente, principalmente aqueles relacionados à disponibilidade do sistema, à segurança dos cadastros de usuários e à proteção das informações confidênciais.

Essa classificação corresponde a uma avaliação inicial, realizada com base nas informações disponíveis sobre o sistema. Os níveis de risco poderão ser reavaliados e ajustados conforme sejam obtidos novos dados sobre o funcionamento da aplicação, os usuários, as vulnerabilidades identificadas ou eventuais incidentes registrados.
