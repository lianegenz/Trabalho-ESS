public class TesteSeguranca {

    public static void main(String[] args) {

        System.out.println("=== TESTE 1: AUTORIZAÇÃO ===");

        testarAutorizacao(
                "Quiropraxista Majoritário",
                "Gerenciar usuários",
                "permitido"
        );

        testarAutorizacao(
                "Quiropraxista",
                "Gerenciar usuários",
                "negado"
        );

        testarAutorizacao(
                "Secretária",
                "Gerenciar usuários",
                "negado"
        );


        System.out.println("\n=== TESTE 2: VALIDAÇÃO ===");

        testarEntrada("Aline");

        testarEntrada("");

        testarEntrada("A".repeat(101));

        testarEntrada("' OR '1'='1");
    }


    // PRÁTICA 1
    static void testarAutorizacao(
            String usuario,
            String funcionalidade,
            String esperado) {

        String resultado = verificarPermissao(
                usuario,
                funcionalidade
        );

        if (resultado.equals(esperado)) {
            System.out.println(
                    "APROVADO: " + usuario +
                    " -> " + resultado
            );
        } else {
            System.out.println(
                    "REPROVADO: " + usuario +
                    " -> " + resultado
            );
        }
    }


    static String verificarPermissao(
            String usuario,
            String funcionalidade) {

        if (usuario.equals("Quiropraxista Majoritário")
                && funcionalidade.equals("Gerenciar usuários")) {

            return "permitido";
        }

        return "negado";
    }


    // PRÁTICA 2
    static void testarEntrada(String nome) {

        String resultado = validarEConsultar(nome);

        System.out.println(
                "Entrada: [" + nome + "]"
        );

        System.out.println(
                "Resultado: " + resultado
        );
    }


    static String validarEConsultar(String nome) {

        // Campo obrigatório
        if (nome == null || nome.isEmpty()) {
            return "Nome obrigatório";
        }

        // Limite de tamanho
        if (nome.length() > 100) {
            return "Nome inválido";
        }

        /*
         * Consulta parametrizada simulada.
         * O valor recebido é tratado como DADO,
         * e não como comando SQL.
         */
        String sql =
                "SELECT id, nome, data_nascimento " +
                "FROM pacientes WHERE nome = ?";

        System.out.println(
                "Consulta parametrizada: " + sql
        );

        return "consulta segura";
    }
}