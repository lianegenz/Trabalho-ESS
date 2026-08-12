### Seleção de Práticas de Código Seguro
Para reduzir possíveis vulnerabilidades e ameaças serão utilizadas medidas de código seguro. Entre elas estão a validação das entradas fornecidas pelos usuários, o cuidado de acesso ao banco de dados, o controle adequado de autenticação e autorização e o armazenamento seguro de dados sensíveis.

Também será importante proteger as senhas e evitar que mensagens de erro mostrem informações importantes do sistema. Essas práticas ajudam a diminuir os riscos de acessos indevidos, alterações não autorizadas no banco de dados e vazamento de informações.

### Testes de Segurança (Antes da Implementação)

Antes da implementação do Quiagenda, serão realizados testes para verificar se os principais mecanismos de segurança estão funcionando corretamente. Os testes serão realizados em um ambiente separado do sistema real, evitando impactos nos dados utilizados pela clínica.

Serão considerados os seguintes testes:

- **Testes de autenticação:** verificar se somente usuários com credenciais válidas conseguem acessar o sistema;
- **Testes de autorização:** verificar se cada perfil consegue acessar somente as funcionalidades permitidas;
- **Teste de acesso administrativo:** tentar acessar funções administrativas utilizando uma conta sem essas permissões;
- **Testes contra SQL Injection:** utilizar entradas de teste para verificar se o sistema impede comandos SQL não autorizados;
- **Testes de validação de entrada:** verificar se dados inválidos ou inesperados são rejeitados corretamente;
- **Testes de gerenciamento de sessão:** verificar o comportamento após logout, expiração da sessão e tentativas de reutilização de uma sessão encerrada;
- **Análise de dependências:** verificar se as bibliotecas utilizadas possuem vulnerabilidades conhecidas;
- **Análise estática do código:** utilizar ferramentas para identificar possíveis problemas de segurança no código;
- **Testes de configuração:** verificar configurações relacionadas a acesso, banco de dados, ambiente e serviços utilizados pela aplicação;
- **Testes de disponibilidade:** verificar o comportamento do sistema diante de uma quantidade elevada de requisições em ambiente controlado;
- **Verificação dos logs:** confirmar se operações importantes, tentativas de acesso e alterações são registradas corretamente.

Os resultados dos testes serão utilizados para identificar problemas que deverão ser corrigidos antes da disponibilização do sistema. Dessa forma, a etapa de testes funciona como uma verificação das medidas de segurança definidas anteriormente, sem repetir a análise de ameaças e riscos realizada nas etapas anteriores.

### Implementação ou Descrição Detalhada
As medidas de segurança serão aplicadas de acordo com os riscos identificados do sistema.

O acesso ao sistema será controlado por usuário e senha, e cada usuário terá permissões de acordo com sua função. Os profissionais de quiropraxia e as secretárias poderão ter acessos diferentes, dependendo das atividades que precisam realizar.

Os dados dos pacientes e seus prontuários deverão ser protegidos, permitindo o acesso somente aos usuários autorizados. As informações financeiras, como pagamentos, receitas e despesas, também deverão possuir controle de acesso e registros das operações realizadas.

Na agenda, somente usuários autorizados poderão criar, alterar ou cancelar agendamentos. Também serão registrados os principais acessos e alterações realizados no sistema, facilitando a identificação de possíveis problemas.

Com essas medidas, o Quiagenda poderá ter maior proteção contra acessos indevidos, alterações não autorizadas e exposição das informações armazenadas no sistema.
