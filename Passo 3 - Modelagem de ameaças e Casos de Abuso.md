## 5. Modelagem de ameaças com STRIDE
| ID | Categoria STRIDE | Componente ou ativo | Ameaça | Impacto previsto |
| --- | --- | --- | --- | --- |
| T01 | Spoofing | Cadastro de pacientes, agendamento de consultas, dados pessoais dos pacientes, histórico de atendimentos | Um atacante obtém credenciais e acessa o cadastro do quiropraxista ou administrador com o intuíto de obter informações de pacientes | Violação de privacidade e obtenção indevida de informações confidenciais |
| T02 | Tempering | Banco de dados | Um atacante altera dados de pacientes, financeiros, agendamentos, usuários e demais informações cruciais para o sistema | Desorganização de agendamentos, perda de registros financeiros, erros nas informações de pacientes |
| T03 | Repudiation | Pagamentos, registros e logs | Um paciente nega ter recebido o comprovante do pagamento de uma consulta e o sistema não possui registros salvos/confiáveis | Impossibilidade de responsabilização e dificuldade para resolver contestações por falta de provas |
| T04 | Information Disclosure | Dados pessoais dos pacientes | Um atacante acessa a conta de um paciente e obtem o histórico de consultas, prontuários e outras informações sensíveis |  Violação de privacidade e exposição de informações de saúde |
| T05 | Denial of Service | Portal web, autenticação e/ou API | Um atacante envia uma grande quantia de solicitações de cadastros ao site | Indisponibilidade do sistema e prejuízo aos pacientes reais |
| T06 | Elevation of Privilege | Controle de permissões| Um paciente mal-intencionado percebe uma falha de autorização e obtém permissão de secretária ou quiropraxista | Alterações nos cadastros de pacientes, agendar consultas não permitidas e/ou falsas, alterar outras permissões de usuários, controle financeiro e registro de procedimentos não autorizados | 

### 5.1 Interpretação da análise

As ameaças demonstram que diversas partes do sistema devem ser protegidas, em específico os usuários admnistrativos e o banco de dados; O agendamento de consultas e registros de pagamentos dependem da integridade dos dados; Os logs e outros registros permitem responsabilizar os autores das operações; Histórico medico, informações de cadastro, consultas e de pagamentos devem ser protegidos de forma confidencial; O portal precisa estar disponível e orientar sobre como entrar em contato com a clínica e realizar o cadastro, além de informar o horário de funcionamento; Dados confidenciais e funções administrativas devem ser acessíveis apenas para usuários autorizados.

## 6. Casos de abuso

### CA01 — Obtenção de informações confidenciais através do cadastro de quiropraxista ou administrador

**Ator:** Atacante externo.

**Objetivo:** Obter informações pessoais de um paciente.

**Condições necessárias:**

- o atacante obtém as credenciais de um funcionário autorizado a realizar consultas;
- o sistema não exige uma verificação adicional para operações importantes;
- o sistema armazena registros anteriores e o histórico de consultas;
- a conta da vítima pode ser acessada somente com o usuário e a senha obtidos.

**Fluxo de abuso:**

1. O atacante obtém o usuário e a senha do funcionário;
2. O atacante acessa o sistema utilizando a identidade da vítima;
3. O atacante obtem as informações de consultas e pacientes.

**Impacto esperado:** Violação de privacidade e obtenção indevida de informações confidenciais, necessidade de contestação e prejuízo ao paciente.

**Categorias STRIDE relacionadas:** Spoofing e Information Disclosure.


---

## CA02 — Alterações no banco de dados

**Ator:** Atacante externo.

**Objetivo:** Alterar diversas informações e desorganizar o banco de dados.

**Condições necessárias:**

- O atacante encontra brechas na segurança e acessa o banco de dados;
- O sistema não possui medidas de checagem de autorização;
- O sistema não possui criptografia de rede;
- O atacante consegue realizar uma injeção de SQL efetiva.

**Fluxo de abuso:**

1. O atacante realiza a inserção do SQL injection;
2. O atacante acessa e lê as informações do banco de dados;
3. O atacante realiza diversas alterações não autorizadas.

**Impacto esperado:** Desorganização e dificuldade em acompanhar agendamentos realizados, perda de registros importantes, erros e inconsistências nas informações de usuários e pacientes.

**Categorias STRIDE relacionadas:** Tampering.

---

## CA03 — Negação do pagamento de consulta

**Ator:** Usuário cadastrado.

**Objetivo:** Adquirir benefício ou reembolso devido a um erro de registro do sistema.

**Condições necessárias:**

- O usuário não realiza o pagamento e decide fazer uma reclamação;
- O sistema não armazena registros de pagamentos de forma eficiente, dificultando a comprovação de pagamentos efetuados;
- O sistema não possui comprovantes ao registrar pagamentos.

**Fluxo de abuso:**

1. O usuário agenda uma consulta com o quiropraxista/secretária;
2. O usuário realiza a consulta com o quiropraxista na clínica;
3. O usuário afirma ter efetuado o pagamento mas diz que não recebeu o comprovante;
4. O usuário solicita um reembolso, mesmo sem realizar o pagamento.

**Impacto esperado:** Prejuízo financeiro, impossibilidade de responsabilização e dificuldade para resolver contestações por falta de provas.

**Categorias STRIDE relacionadas:** Repudiation.

---

## CA04 — Acesso não autorizado ao cadastro do usuário

**Ator:** Atacante externo.

**Objetivo:** Acessar cadastro de usuário para obter informações confidenciais.

**Condições necessárias:**

- O atacante obtém o usuário e a senha do paciente;
- O sistema não exige uma verificação adicional;
- O sistema armazena registros anteriores e o histórico de consultas;
- A conta da vítima pode ser acessada somente com o usuário e a senha obtidos.

**Fluxo de abuso:**

1. O atacante obtem as credenciais de cadastro da vítima;
2. O atacante acessa o sistema utilizando a identidade da vítima;
3. O atacante obtem as informações de saúde, consultas e histórico médico da vitima.

**Impacto esperado:** Violação de privacidade, roubo e exposição de informações de saúde e dados pessoais.

**Categorias STRIDE relacionadas:** Spoofing e Information Disclosure.


## 7. Considerações finais

As ameaças que foram consideradas mais preocupantes são o acesso indevido ás contas cadastradas, a alteração de informações sem autorização, a obtenção de permissões administrativas e a indisponibilidade do sistema durante o período de funcionamento.

Os ativos mais importantes são as credenciais, os dados pessoais e prontuários de usuários, as solicitações de agendamento de consultas, a disponibilidade do sistema, as permissões de acesso e os registros das operações do sistema.

Os casos de abuso com maior impacto são a obtenção de privilégios administrativos, alterações no banco de dados e o acesso não autorizado ao cadastro dos usuários, pois podem causar prejuízos financeiros e administrativos de forma direta e comprometer a confiança no sistema.

A principal dificuldade da análise foi identificar quais ameaças afetariam os diferentes ativos e outras partes do sistema de forma concreta. A utilização do STRIDE ajudou a separar ameaças em diferentes classificações mais objetivas e ao modelar os casos de abuso, além da examinação do software sob diferentes perspectivas e a identificar ameaças que poderiam não ser percebidas em uma análise apenas funcional.
