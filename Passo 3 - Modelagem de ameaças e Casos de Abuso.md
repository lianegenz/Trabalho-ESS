## 5. Modelagem de ameaças com STRIDE
| ID | Categoria STRIDE | Componente ou ativo | Ameaça | Impacto previsto |
| --- | --- | --- | --- | --- |
| T01 | Spoofing | Cadastro de pacientes, agendamento de consultas | Um usuário malicioso obtém credenciais e se passa por quiroprata/secretária e agenda consultas falsas com o intuíto de obter informações de pacientes |Violação de privacidade e obtenção indevida de informações confidenciais |
| T02 | Tempering | Banco de dados | Um atacante altera dados de pacientes, financeiros, agendamentos, usuários e demais informações cruciais para o sistema | Desorganização de agendamentos, perda de registros financeiros, erros nas informações de pacientes |
| T03 | Repudiation | Pagamentos, registros e logs | Um paciente nega ter efetuado o pagamento de uma consulta e o sistema não possui registros salvos/confiáveis | Impossibilidade de responsabilização e dificuldade para resolver contestações por falta de provas |
| T04 | Information Disclosure | Dados pessoais dos pacientes | Um atacante acessa a conta de um paciente e obtem o histórico de consultas, prontuários e outras informações sensíveis |  Violação de privacidade e exposição de informações de saúde |
| T05 | Denial of Service | Portal web, autenticação e/ou API | Um atacante envia uma grande quantia de solicitações de cadastros ao site | Indisponibilidade do sistema e prejuízo aos pacientes reais |
| T06 | Elevation of Privilege | Controle de permissões| Um paciente percebe uma falha de autorização e obtém permissão de secretária ou quiropraxista | Alterações nos cadastros de pacientes, agendar consultas não permitidas e/ou falsas, alterar outras permissões de usuários, controle financeiro e registro de procedimentos não autorizados | 

### 5.1 Interpretação da análise

As ameaças demonstram que diversas partes do sistema devem ser protegidas, em específico os usuários admnistrativos e o banco de dados; O agendamento de consultas e registros de pagamentos dependem da integridade dos dados; Os logs e outros registros permitem responsabilizar os autores das operações; Histórico medico, informações de cadastro, consultas e de pagamentos devem ser protegidos de forma confidencial; O portal precisa estar disponível e orientar sobre como entrar em contato com a clínica e realizar o cadastro, além de informar o horário de funcionamento; Dados confidenciais e funções administrativas devem ser acessíveis apenas para usuários autorizados.

## 6. Casos de abuso

### CA01 —




## 7. Considerações finais
