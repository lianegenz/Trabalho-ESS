## 3. Usuários, ativos e pontos de interação

### 3.1 Usuários e perfis

| Usuário ou perfil | Principais ações |
| --- | --- |
| Administrador/ Quiropraxista majoritário | Gerenciar usuários e permissões, cadastrar e consultar pacientes, acessar e registrar procedimentos nos prontuários, acessar e gerenciar a agenda e controle financeiro |
| Quriopraxista | Consultar a agenda, acessar e registrar procedimentos nos prontuários |
| Secretária | Cadastrar pacientes, realizar e gerenciar agendamentos, consultar a agenda, registrar pagamentos, controle financeiro relacionado ao caixa |

### 3.2 Ativos importantes

Os principais ativos identificados são:
- credenciais de acesso
- dados pessoais dos pacientes
- prontuários (avaliações, escalas de dor, representações da coluna 3D e anamneses) dos pacientes
- histórico de atendimentos
- registros financeiros (aluguel, água, luz, etc.)
- registros de pagamentos
- registros de mensagens e notificações enviadas
- permissões de acesso dos usuários
- registros e logs das operações realizadas
- disponibilidade de consultas
- disponibilidade do sistema

### 3.3 Pontos de interação e componentes

| Elemento | Função |
| --- | --- |
| Portal web | Interface utilizada pelos usuários |
| Serviço de autenticação | Valida a identidade e as credenciais dos usuários |
| Controle de permissões | Define quais funcionalidades e informações cada perfil pode acessar |
| Módulo de Quiropraxista | Permite cadastrar, consultar e atualizar os dados dos pacientes |
| Módulo de agenda | Permite cadastrar, consultar e atualizar os dados dos pacientes |
| Módulo de prontuário | Permite cadastrar, consultar e atualizar os dados dos pacientes |
| Módulo de avaliação de dor | Avalia o grau da dor |
| Representação 3D da coluna | Apenas Visual |
| Módulo financeiro | Permite cadastrar, consultar e atualizar os dados financeiros |
| Aplicação ou API | Processa as regras e operações do sistema |
| Banco de dados | Armazena dados pessoais, clínicos, financeiros, agendamentos, usuários e demais informações |
| Serviço de WhatsApp/notificações | Realiza o envio de mensagens, como confirmações e lembretes de consultas |
