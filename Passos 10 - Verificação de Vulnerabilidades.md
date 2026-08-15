### 16. Configuração do Ambiente e Ferramenta

Para a verificação das práticas de código seguro e das vulnerabilidades foi utilizado um ambiente local e autorizado para fins educacionais. Inicialmente, foram implementados, com auxílio do ChatGPT, códigos Java mínimos para verificar as duas práticas de código seguro definidas nas etapas anteriores: controle de autenticação e autorização por perfil e validação de entradas com utilização de consultas parametrizadas.

Os códigos foram executados no Visual Studio Code e os testes foram realizados pelo PowerShell. Os resultados demonstraram que o perfil de Quiropraxista Majoritário recebeu acesso permitido à funcionalidade de gerenciamento de usuários, enquanto os perfis de Quiropraxista e Secretária receberam acesso negado. Também foram verificadas entradas válidas, campos vazios, entradas superiores a 100 caracteres e uma entrada de teste relacionada a SQL Injection.

Para a verificação de vulnerabilidades com uma ferramenta de segurança, foi utilizado o OWASP Juice Shop, uma aplicação deliberadamente vulnerável destinada a treinamento e testes de segurança. A aplicação foi instalada localmente utilizando Node.js e npm e executada por meio do PowerShell. Após a inicialização, o sistema ficou disponível localmente na porta 3000.

A ferramenta OWASP ZAP foi utilizada para realizar a verificação de segurança da aplicação. O teste foi executado contra o endereço local do Juice Shop, http://localhost:3000, garantindo que a análise ocorresse em um ambiente autorizado e controlado.

A sessão de verificação permitiu identificar alertas de diferentes níveis de risco. Foram selecionados três achados para análise: configuração incorreta de CORS, ausência do cabeçalho Content Security Policy (CSP) e divulgação de timestamp Unix.

As evidências da execução e as capturas de tela dos resultados do ZAP foram armazenadas no diretório evidências.

### 17. Análise de Alertas e Achados

Durante a verificação realizada pelo OWASP ZAP no OWASP Juice Shop, foram identificados diferentes alertas. Para a análise desta etapa foram selecionados três achados relevantes. O resultado informativo relacionado a "Modern Web Application information" não foi utilizado como um dos três principais achados, pois possui caráter predominantemente informativo.

Para facilitar a interpretação dos resultados obtidos durante a verificação, a tabela a seguir apresenta os principais alertas identificados pelo OWASP ZAP, seus possíveis impactos e a relação com vulnerabilidades e boas práticas de segurança.




**A01 - Configuração Incorreta entre Domínios (CORS)**

O primeiro alerta identificado pelo ZAP foi relacionado à configuração do mecanismo CORS. O servidor permite solicitações de leitura entre domínios de origens potencialmente arbitrárias em determinadas APIs não autenticadas.

A configuração excessivamente permissiva pode permitir que aplicações hospedadas em outros domínios realizem requisições e leiam respostas que deveriam estar restritas. O risco é maior quando informações importantes estão disponíveis sem autenticação adequada.

O próprio alerta indica que as políticas do navegador reduzem parcialmente o risco quando as APIs exigem autenticação, pois aplicações de terceiros não conseguem simplesmente ler respostas de APIs autenticadas.

**A02 - Content Security Policy (CSP) Header Not Set**

O segundo alerta indica a ausência do cabeçalho Content-Security-Policy.

A CSP funciona como uma camada adicional de segurança, permitindo que a aplicação defina quais fontes de conteúdo podem ser carregadas pelo navegador. Esse mecanismo pode ajudar a reduzir o impacto de determinados ataques, especialmente ataques de Cross-Site Scripting (XSS) e injeção de conteúdo.

A ausência do cabeçalho não significa necessariamente que a aplicação seja vulnerável diretamente a XSS, mas representa a ausência de uma camada de defesa recomendada.

**A03 - Divulgação de Data e Hora - Unix**

O terceiro alerta corresponde à divulgação de um timestamp Unix pela aplicação. O valor identificado pelo ZAP foi 1528301887, correspondente a 2018-06-06 13:18:07.

Esse tipo de informação possui baixo impacto isoladamente. Entretanto, informações temporais podem ser utilizadas juntamente com outros dados para identificar padrões de funcionamento, versões, eventos ou períodos de atividade da aplicação.

Por esse motivo, o resultado foi classificado como um achado de baixo risco e deve ser avaliado manualmente para verificar se o timestamp possui alguma importância para a segurança ou para o funcionamento da aplicação.

Os achados identificados pelo ZAP complementam as práticas de código seguro definidas anteriormente, permitindo verificar, em um ambiente web, aspectos relacionados ao controle de acesso, proteção de dados e configuração segura da aplicação.

### 18. Propostas de Correção

**A01 - Configuração Incorreta de CORS**

A configuração do CORS deve ser restringida para permitir somente origens confiáveis e necessárias ao funcionamento da aplicação.

O cabeçalho Access-Control-Allow-Origin deve utilizar uma lista restrita de domínios autorizados, evitando configurações que permitam origens arbitrárias.

Também deve ser verificado se informações sensíveis estão disponíveis sem autenticação. Dados confidenciais não devem depender somente de mecanismos como listas de endereços IP para sua proteção.

Quando o CORS não for necessário, os cabeçalhos relacionados podem ser removidos, permitindo que a Same Origin Policy (SOP) do navegador forneça uma restrição mais rígida.
Após a aplicação das correções, os testes de segurança deverão ser executados novamente para verificar se os problemas identificados foram corrigidos ou se os riscos foram reduzidos.

**A02 - Content Security Policy**

A aplicação deve configurar o cabeçalho HTTP Content-Security-Policy no servidor.

A política deve definir explicitamente quais fontes de JavaScript, CSS, imagens, fontes e demais recursos podem ser carregadas pela aplicação.

A configuração deve ser construída de acordo com os recursos realmente utilizados pelo sistema, evitando permissões excessivamente amplas. Dessa forma, a CSP passa a funcionar como uma camada adicional de proteção contra XSS e ataques de injeção de conteúdo.

**A03 - Divulgação de Data e Hora**

Deve ser realizada uma análise manual para verificar se o timestamp divulgado é realmente necessário e se possui alguma informação sensível.

Caso o valor não seja necessário para o funcionamento da aplicação, recomenda-se evitar sua exposição nas respostas destinadas ao usuário.

Quando a informação temporal for necessária, deve-se avaliar se é possível fornecer somente a informação necessária, evitando a exposição de dados internos que possam ser utilizados para identificar padrões exploráveis.
