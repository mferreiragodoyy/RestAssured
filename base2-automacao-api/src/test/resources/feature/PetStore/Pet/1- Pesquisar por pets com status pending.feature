@Test4
Feature: Pesquisar pets com o mesmo status

	Como um usuário do sistema
	Eu quero pesquisar por pets com um status específico
	Para garantir que posso encontrar os pets desejados de acordo com seu status

	Scenario: Pesquisar por pets com status pending
		Given que eu acesso o endpoint de busca
		When eu informo o status pending
		And eu clico em executar
		Then o servico deve retornar o status code 200
		And o corpo da resposta deve conter a lista de pets com status pending
