@Test1
Feature: Processar um pedido de pet

	Como um usuário do sistema
	Eu quero criar um pedido de pet
	Para garantir que meu pedido seja registrado corretamente

	Scenario: Criar um pedido de pet com sucesso
		Given que eu acesso o endpoint store order
		When eu informo os dados solicitados para o pedido
		And eu clico em executar
		Then o servico deve retornar um status code 200
		And o corpo da resposta deve conter os dados da inclusao do pedido