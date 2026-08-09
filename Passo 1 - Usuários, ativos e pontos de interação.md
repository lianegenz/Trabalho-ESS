## 3. Usuários, ativos e pontos de interação

### 3.1 Usuários e perfis

| Usuário ou perfil | Principais ações |
| --- | --- |
| Administrador/ Quiropraxista majoritário | Gerenciar usuários e permissões, consultar e atualizar pacientes, realizar e acompanhar atendimentos, acessar prontuários, avaliações, agenda e informações financeirass |
| Quriopraxista | Consultar agenda, cadastrar e consultar pacientes, realizar avaliações, registrar escalas de dor, utilizar a representação da coluna 3D e registrar procedimentos no prontuário |
| Secretária | Cadastrar pacientes, realizar e gerenciar agendamentos, consultar a agenda, registrar pagamentos, controlar o fluxo de caixa e realizar atividades administrativas |

### 3.2 Ativos importantes

Os principais ativos identificados são:
- credenciais de acesso
- dados pessoais dos pacientes
- informações utilizadas para emissão de notas fiscais
- prontuários (avaliações, escalas de dor, representações da coluna 3D e anamneses) dos pacientes
- histórico de atendimentos
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
| Módulo de avaliação de dor | Permite cadastrar, consultar e atualizar os dados dos pacientes |
| Representação 3D da coluna | Permite cadastrar, consultar e atualizar os dados dos pacientes |
| Módulo financeiro | Permite cadastrar, consultar e atualizar os dados dos pacientes |
| Aplicação ou API | Processa as regras e operações do sistema |
| Banco de dados acadêmico | Armazena dados pessoais, clínicos, financeiros, agendamentos, usuários e demais informações |
| Serviço de WhatsApp/notificações | Realiza o envio de mensagens, como confirmações e lembretes de consultas |
