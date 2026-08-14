### 19. Conceitos de Monitoramento
### 20. O que é detecção de intrusões?
A detecção de intrusões trata-se do procedimento de identificação de atividades consideradas suspeitas ou maliciosas em um sistema. Que possui o objetivo de perceber quando alguém está tentando acessar, alterar ou usar recursos de uma forma do qual não deveria ser possível.

### 21. Diferença entre prevenir e detectar
O ato de prevenir tem o significado de criar mecanismos para tentar impedir que ataques possam acontecer tendo como exemplos a autenticação, o controle de acesso e senha entre outros exemplos.
Enquanto, detectar significa identificar se uma atividade suspeita está acontecendo ou se já aconteceu. Ou seja, a prevenção tenta bloquear as ameaças e em contrapartida a detecção tenta perceber e alertar sobre ameaças.

### 22. Eventos do sistema que devem ser registrados
Após uma análise profunda realizada pela nossa equipe decidimos que para conseguir detectar possíveis intrusões, o sistema deve registrar eventos importantes como:
- Tentativas de login, tanto bem-sucedidas quanto falhas;
- Acessos e alterações de dados de todos os tipos;
- Criação, alteração ou exclusão de usuários;
- Mudanças de permissões e níveis de acesso;
- Alterações em configuração do sistema;
- Erros e atividades consideradas suspeitas;
  
E vale ressaltar que esses registros são chamados de logs que permitem identificar comportamentos tanto anormais quanto normais e investigar possíveis incidentes de segurança.

### 23. Regras de Detecção
As regras de detecção foram definidas considerando os principais riscos identificados no sistema. Para cada situação, foram estabelecidos o risco observado, a fonte de dados utilizada no monitoramento, a condição que deverá gerar um alerta e a resposta inicial ao possível incidente.

### 23.1 Regra 1 – Tentativas repetidas de login

**Risco observado:** tentativa de acesso não autorizado por meio de repetidas tentativas de autenticação.

**Fonte de dados:** logs de autenticação do sistema.

**Condição de alerta:** ocorrência de várias tentativas de login com senha incorreta para a mesma conta ou a partir do mesmo endereço de origem em um curto período de tempo.

**Resposta inicial:** bloquear temporariamente novas tentativas de acesso, registrar o evento e gerar um alerta para o responsável pelo sistema.

### 23.2 Regra 2 – Acesso indevido a prontuários

**Risco observado:** tentativa de consulta ou alteração de prontuários por usuário sem autorização.

**Fonte de dados:** logs de acesso, perfil e permissões do usuário e registros de acesso aos prontuários.

**Condição de alerta:** tentativa de consultar ou alterar um prontuário por usuário que não possua permissão para essa funcionalidade.

**Resposta inicial:** impedir o acesso, registrar a tentativa e gerar um alerta para o responsável pelo sistema.

O **Quiropraxista** e o **Quiropraxista Majoritário** poderão acessar os prontuários de acordo com suas permissões, sendo que o Majoritário também possui as funcionalidades adicionais relacionadas à administração do sistema.

### 23.3 Regra 3 – Alterações suspeitas em registros financeiros

**Risco observado:** alteração, exclusão ou registro indevido de pagamentos e outras informações financeiras.

**Fonte de dados:** logs do módulo financeiro, perfil e permissões do usuário e histórico das movimentações.

**Condição de alerta:** tentativa de alterar, excluir ou registrar informações financeiras por usuário sem permissão ou ocorrência de movimentações fora do padrão esperado.

**Resposta inicial:** registrar o evento, gerar um alerta e verificar o histórico da movimentação e o usuário responsável pela operação.
