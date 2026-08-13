### Conceitos de Monitoramento: Breve explicação sobre a diferença entre prevenir e detectar, e quais eventos registrar (logs)

###  Regras de Detecção
As regras de detecção foram definidas considerando os principais riscos identificados no sistema. Para cada situação, foram estabelecidos o risco observado, a fonte de dados utilizada no monitoramento, a condição que deverá gerar um alerta e a resposta inicial ao possível incidente.

### Regra 1 – Tentativas repetidas de login

**Risco observado:** tentativa de acesso não autorizado por meio de repetidas tentativas de autenticação.

**Fonte de dados:** logs de autenticação do sistema.

**Condição de alerta:** ocorrência de várias tentativas de login com senha incorreta para a mesma conta ou a partir do mesmo endereço de origem em um curto período de tempo.

**Resposta inicial:** bloquear temporariamente novas tentativas de acesso, registrar o evento e gerar um alerta para o responsável pelo sistema.

### Regra 2 – Acesso indevido a prontuários

**Risco observado:** tentativa de consulta ou alteração de prontuários por usuário sem autorização.

**Fonte de dados:** logs de acesso, perfil e permissões do usuário e registros de acesso aos prontuários.

**Condição de alerta:** tentativa de consultar ou alterar um prontuário por usuário que não possua permissão para essa funcionalidade.

**Resposta inicial:** impedir o acesso, registrar a tentativa e gerar um alerta para o responsável pelo sistema.

O **Quiropraxista** e o **Quiropraxista Majoritário** poderão acessar os prontuários de acordo com suas permissões, sendo que o Majoritário também possui as funcionalidades adicionais relacionadas à administração do sistema.

### Regra 3 – Alterações suspeitas em registros financeiros

**Risco observado:** alteração, exclusão ou registro indevido de pagamentos e outras informações financeiras.

**Fonte de dados:** logs do módulo financeiro, perfil e permissões do usuário e histórico das movimentações.

**Condição de alerta:** tentativa de alterar, excluir ou registrar informações financeiras por usuário sem permissão ou ocorrência de movimentações fora do padrão esperado.

**Resposta inicial:** registrar o evento, gerar um alerta e verificar o histórico da movimentação e o usuário responsável pela operação.
