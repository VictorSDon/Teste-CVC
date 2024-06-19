# Teste-CVC

## Log de desenvolvimento

- 13/06 - criação do repositório no GitHub 
- 14/06 - estudo da API do GitHub
- 16/06 - desenvolvimento do fluxo das listagens de repositório completas
- 16/06 - fiz a configuração do Feign Client no projeto e montei as rotas necessarias para puxar as informações do GitHub
- 16/06 - criei o service de modo que a mesma possa servir de intermediador 
- 16/06 - entre a controller e buscando as informações no GitHub
- 16/06 - criei a controller que é a porta de entrada da aplicação
- 17/06 - implementação dos endpoints de criação de CSV - implementação do 
- 17/06 - filewritter para a criação dos arquivos CSV
- 18/06 - implementação de testes unitários da controller - verificando se as rotas estão chamando as funções necessarias e retornando o statuscode adequado 
- 19/06 - implementação de testes unitários da service  - verificando se as regras de negocio estão sendo aplicadas corretamente
- 19/06 - implementação do swagger - configuração basica
- 19/06 - comentário da aplicação
- 19/06 - criação da coleção do postman - gerado a partir do swagger
- 19/06 - adicionei a tratativa de erros no service.

## Como Rodar

Para rodar a aplicação Spring em sua máquina, uma das maneiras seria executar o metodo 'main' na com.donato.Junior.test.Application.
Ou usando o plugin do Boot Maven: 
```mvn spring-boot:run```
