### 14. Seleção de Práticas de Código Seguro
Para esta etapa, foram selecionadas duas práticas de código seguro diretamente relacionadas aos riscos identificados na análise de ameaças: **controle de autenticação e autorização por perfil e validação de entradas com utilização de consultas parametrizadas**.

**Prática 1:** Controle de autenticação e autorização por perfil

**Pseudocódigo:**

```
ALGORITMO

DECLARE usuario, funcionalidade, permissoes LITERAL
LEIA usuario, funcionalidade

SE usuario_autenticado == falso 
  ENTÃO ESCREVA "Acesso negado"
  
SENÃO
  permissoes **←** obterPermissoes(usuario) 
  
SE funcionalidade_presente == falso 
  ENTÃO registrarLog(usuario, "Tentativa de acesso não autorizado", funcionalidade)
  ESCREVA "Acesso negado"
  
SENÃO
  registrarLog(usuario, "Acesso autorizado", funcionalidade)
  ESCREVA "Acesso permitido" 
  
FIM_ALGORITMO
```

**Prática 2:** Validação de entradas e SQL Injection

**Pseudocódigo:**
```
ALGORITMO 

DECLARE nome, consulta, resultado LITERAL
LEIA nome

SE nome == ""
  ENTÃO ESCREVA "Nome obrigatório"

SENÃO
  SE tamanho(nome) > 100
    ENTÃO ESCREVA "Nome inválido"

SENÃO
  nome ← validarEntrada(nome)
  consulta ← "SELECT id, nome, data_nascimento FROM pacientes WHERE nome = ?"
  resultado ← executarConsultaParametrizada(consulta, nome)
  ESCREVA resultado

FIM_ALGORITMO
```

### 14.1. Testes de Segurança (Antes da Implementação)

**Teste 1 — Controle de acesso por perfil**

Objetivo: verificar se o sistema impede que usuários acessem funcionalidades que não pertencem ao seu perfil.

Procedimento:

1. Acessar o sistema com uma conta de Quiropraxista Majoritário.
2. Tentar acessar a funcionalidade de gerenciamento de usuários.
3. Repetir o teste utilizando uma conta de Quiropraxista.
4. Repetir o teste utilizando uma conta de Secretária.
5. Verificar os resultados e os registros de log.

Resultado esperado:

- Quiropraxista Majoritário → acesso permitido.
- Quiropraxista → acesso negado.
- Secretária → acesso negado.
- As tentativas de acesso não autorizado devem ser registradas nos logs.

**Teste 1.1 — Tentativa de acesso direto**

Objetivo: verificar se o controle de autorização funciona no servidor mesmo quando o usuário tenta acessar diretamente uma funcionalidade restrita.

Procedimento:

1. Utilizar uma conta de Quiropraxista.
2. Tentar acessar diretamente a URL ou endpoint de gerenciamento de usuários.

Resultado esperado: o sistema deve negar o acesso, mesmo que o usuário tente acessar a funcionalidade diretamente.

**Teste 2 — Validação de entrada e SQL Injection**

Objetivo: verificar se o sistema valida os dados fornecidos pelo usuário e impede que entradas maliciosas sejam executadas como comandos SQL.

Procedimento:

1. Realizar uma consulta utilizando um nome válido, por exemplo: Aline
2. Realizar uma consulta com o campo vazio.
3. Realizar uma consulta com mais de 100 caracteres.
4. Realizar uma consulta utilizando uma entrada de teste contendo uma tentativa de SQL Injection.
5. Verificar se a consulta é executada utilizando parâmetros.

Resultado esperado:

- Nome válido → consulta realizada normalmente.
- Campo vazio → entrada rejeitada.
- Mais de 100 caracteres → entrada rejeitada.
- Entrada de teste de SQL Injection → não deve executar comandos SQL indevidos.
- O banco de dados não deve sofrer alterações não autorizadas.

### 15. Implementação ou Descrição Detalhada
As medidas de segurança serão aplicadas de acordo com os riscos identificados nas etapas anteriores. Nesta etapa, são detalhadas principalmente as duas práticas de código seguro selecionadas: controle de autenticação e autorização por perfil e validação de entradas com utilização de consultas parametrizadas.

**15.1 Controle de autenticação e autorização por perfil**

O acesso ao sistema será controlado por contas individuais de usuário. Cada usuário deverá realizar a autenticação antes de acessar as funcionalidades internas da aplicação.

Após a autenticação, o sistema deverá identificar o perfil do usuário e verificar suas permissões antes de executar cada operação. Essa verificação deverá ocorrer no servidor, evitando que um usuário consiga acessar uma funcionalidade restrita apenas manipulando URLs, parâmetros ou requisições.

O Quiropraxista Majoritário terá acesso às funcionalidades administrativas, além das funcionalidades disponíveis ao Quiropraxista. O Quiropraxista terá acesso às funcionalidades relacionadas aos atendimentos e prontuários. A Secretária terá acesso às funcionalidades administrativas relacionadas às suas atividades, como cadastro de pacientes, agenda e registros financeiros permitidos.

Dessa forma, um usuário não poderá executar operações que não estejam relacionadas às suas permissões. Tentativas de acesso não autorizado deverão ser registradas para possibilitar posterior investigação.

**15.2 Validação de entradas e proteção contra SQL Injection**

As informações fornecidas pelos usuários deverão ser validadas antes de serem processadas ou armazenadas. Serão verificadas características como preenchimento obrigatório, tamanho, formato e conteúdo dos dados.

As operações realizadas no banco de dados deverão utilizar consultas parametrizadas. Dessa forma, informações fornecidas pelos usuários serão tratadas como dados e não como comandos SQL, reduzindo o risco de SQL Injection e de alterações não autorizadas no banco de dados.

Por exemplo, ao realizar uma consulta de paciente, o nome informado pelo usuário deverá ser enviado como parâmetro da consulta, evitando que uma entrada maliciosa seja interpretada como parte do comando SQL.

Além disso, as operações de cadastro, alteração e consulta deverão ser realizadas por meio da aplicação, sem permitir que usuários acessem diretamente o banco de dados.

**15.3 Proteção dos dados e registros**

Os dados dos pacientes e seus prontuários deverão ser protegidos, permitindo o acesso somente aos usuários autorizados. As informações financeiras também deverão possuir controle de acesso e registros das operações realizadas.

Alterações importantes nos prontuários, agendamentos, permissões e registros financeiros deverão ser registradas, permitindo identificar o usuário responsável pela ação.

Após a implementação, as práticas deverão ser submetidas aos testes de segurança definidos anteriormente. Caso algum teste de autenticação, autorização, validação de entrada ou proteção contra SQL Injection apresente falha, a implementação deverá ser corrigida antes da disponibilização do sistema.

Com essas medidas, o Quiagenda poderá ter maior proteção contra acessos indevidos, alterações não autorizadas e exposição das informações armazenadas no sistema.
