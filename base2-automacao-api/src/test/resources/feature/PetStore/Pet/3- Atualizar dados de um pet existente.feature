@Test3
Feature: Atualizar dados de um pet existente

	Como um usuário do sistema
	Eu quero atualizar as informações de um pet existente
	Para garantir que os dados estão corretos e atualizados

	Scenario: Atualizar dados de um pet existente com sucesso
		Given que eu acesso o endpoint de atualizacao
		When eu informo os dados do pet que desejo atualizar
		And eu clico em executar
		Then a chamada deve retornar um status code 200
		And o corpo da resposta deve conter os dados atualizados do pet
