## 5. Modelagem de ameaças com STRIDE
| ID | Categoria STRIDE | Componente ou ativo | Ameaça | Impacto previsto |
| --- | --- | --- | --- | --- |
| T01 | Spoofing | Autenticação e contas de usuários | Um atacante obtém credenciais e acessa o cadastro do quiropraxista majoritário, quiropraxista ou secretária | Acesso não autorizado ao sistema utilizando a identidade de um usuário legítimo, podendo resultar na realização de operações indevidas |
| T02 | Tampering | Banco de dados | Um atacante altera dados de pacientes, financeiros, agendamentos, usuários e demais informações cruciais para o sistema | Desorganização de agendamentos, perda de registros financeiros, erros nas informações de pacientes |
| T03 | Repudiation | Pagamentos, registros e logs | Um usuário contesta a realização de um pagamento ou determinada operação, e o sistema não possui registros confiáveis que permitam comprovar quando, por quem e como a operação foi realizada | Impossibilidade de responsabilização e dificuldade para resolver contestações por falta de provas |
| T04 | Information Disclosure | Dados pessoais dos pacientes | Um usuário mal-intencionado obtém acesso indevido aos prontuários e demais informações sensíveis dos pacientes |  Violação de privacidade e exposição de informações pessoais e de saúde do paciente |
| T05 | Denial of Service | Portal web e autenticação| Um atacante envia uma grande quantidade de solicitações simultâneas ao sistema | Indisponibilidade do sistema e prejuízo aos pacientes e quiropraxistas reais |
| T06 | Elevation of Privilege | Controle de permissões| Um usuário mal-intencionado explora uma falha de autorização e obtém permissões superiores às previstas para seu perfil | Alterações nos cadastros de pacientes, agendar consultas não permitidas e/ou falsas, alterar outras permissões de usuários, controle financeiro e registro de procedimentos não autorizados | 

### 5.1 Interpretação da análise

As ameaças demonstram que diversas partes do sistema devem ser protegidas, em específico os usuários administrativos e o banco de dados, o agendamento de consultas e registros de pagamentos dependem da integridade dos dados, os logs e outros registros permitem responsabilizar os autores das operações. Histórico medico, informações de cadastro, consultas e de pagamentos devem ser protegidos de forma confidencial. O portal precisa estar disponível e orientar sobre como entrar em contato com a clínica e realizar o cadastro, além de informar o horário de funcionamento. Dados confidenciais e funções administrativas devem ser acessíveis apenas para usuários autorizados.

## 6. Casos de abuso

### CA01 — Acesso ao sistema utilizando a identidade de usuário legítimo

**Ator:** Atacante externo.

**Objetivo:** Utilizar a identidade de um usuário legítimo para acessar o sistema.

**Condições necessárias:**

- O atacante obtém as credenciais de um Quiropraxista ou da Secretária;
- O sistema permite o acesso utilizando apenas as credenciais obtidas;
- O atacante consegue utilizar a conta da vítima.
  
**Fluxo de abuso:**

1. O atacante obtém o usuário e a senha do funcionário;
2. O atacante acessa o sistema utilizando a identidade da vítima;
3. O sistema autentica o atacante como se ele fosse legítimo.
4. O atacante tem acesso às funcionalidades disponíveis para aquele perfil.

**Impacto esperado:** Acesso não autorizado ao sistema e possibilidade de realização de operações utilizando a identidade de outro usuário.

**Categorias STRIDE relacionadas:** Spoofing.


---

## CA02 — Alterações no banco de dados

**Ator:** Atacante externo.

**Objetivo:** Alterar diversas informações e desorganizar o banco de dados.

**Condições necessárias:**

- O sistema possui uma vulnerabilidade na validação ou parametrização das entradas;
- O atacante consegue enviar entradas maliciosas ao sistema;
- O atacante consegue explorar a vulnerabilidade para executar comandos SQL não autorizados;
- O sistema não possui mecanismos adequados para impedir ou detectar alterações indevidas no banco de dados;

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

## CA04 — Acesso não autorizado às informações do paciente

**Ator:** Usuário mal-intencionado.

**Objetivo:** Obter informações pessoais e dados de saúde dos pacientes sem autorização.

**Condições necessárias:**

- O usuário consegue acessar o sistema;
- O sistema apresenta uma falha no controle de permissões;
- O usuário consegue visualizar prontuários ou informações de pacientes que não deveriam estar disponíveis para seu perfil;

**Fluxo de abuso:**

1. O usuário acessa o sistema utilizando uma conta válida;
2. O usuário acessa a área de pacientes ou prontuários;
3. O usuário consulta informações que não estão relacionadas às suas permissões;
4. O usuário obtém dados pessoais, histórico de atendimentos e informações de saúde dos pacientes;

**Impacto esperado:** Violação de privacidade, roubo e exposição de informações de saúde e dados pessoais dos pacientes.

**Categorias STRIDE relacionadas:** Information Disclosure.


## 7. Considerações finais

As ameaças que foram consideradas mais preocupantes são o acesso indevido às contas cadastradas, a alteração de informações sem autorização, a obtenção de permissões administrativas e a indisponibilidade do sistema durante o período de funcionamento.

Os ativos mais importantes são as credenciais, os dados pessoais e prontuários de usuários, as solicitações de agendamento de consultas, a disponibilidade do sistema, as permissões de acesso e os registros das operações do sistema.

Os casos de abuso com maior impacto são a obtenção de privilégios administrativos, alterações no banco de dados e o acesso não autorizado ao cadastro dos usuários, pois podem causar prejuízos financeiros e administrativos de forma direta e comprometer a confiança no sistema.

A principal dificuldade da análise foi identificar quais ameaças afetariam os diferentes ativos e outras partes do sistema de forma concreta. A utilização do STRIDE ajudou a separar ameaças em diferentes classificações mais objetivas e ao modelar os casos de abuso, além da examinação do software sob diferentes perspectivas e a identificar ameaças que poderiam não ser percebidas em uma análise apenas funcional.
