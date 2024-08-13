@Test2
Feature: Pesquisar um pet

	Como um usuário do sistema
	Eu quero pesquisar por um pet inexistente
	Para garantir que o sistema esta funcionando corretamente

	Scenario: Pesquisar por um pet inexistente
		Given que eu acesso o endpoint de busca de pets
		When eu informo um petId que nao esta cadastrado
		And eu clico em executar
		Then o servico deve retornar um status 404
		And a mensagem Pet not found deve estar presente na resposta

