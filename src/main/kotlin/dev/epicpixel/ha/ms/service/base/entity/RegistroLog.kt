package dev.epicpixel.ha.ms.service.base.entity
/*
Cada Log deve ter informações como o ID do usuário, a ação realizada, a data e hora da ação, etc.
idRegistro
dataHora
acaoRealizada
idUsuario
detalhesAdicionais

@Entity:
Descrição: Indica que a classe é uma entidade JPA, ou seja, uma classe que será mapeada
para uma tabela no banco de dados.

@Table:
Descrição: Especifica o nome da tabela no banco de dados que será associada à entidade.
Se não for fornecido, o nome padrão será o mesmo que o nome da classe.

@Id:
Descrição: Indica que o campo é a chave primária da entidade. Cada entidade deve ter uma
chave primária para identificar de forma exclusiva cada registro na tabela correspondente.

@GeneratedValue:
Descrição: Especifica a estratégia de geração de valores para a chave primária. Pode ser
usado em conjunto com @Id para indicar que o valor da chave primária será gerado automaticamente
pelo banco de dados.

@Column:
Descrição: Permite especificar opções de mapeamento para uma coluna de banco de dados específica.
Por exemplo, você pode definir o nome da coluna, a precisão e a escala para campos numéricos, o
comprimento máximo para campos de texto, entre outras opções.

@JoinColumn:
Descrição: Usado para especificar a coluna na tabela do banco de dados que está sendo referenciada
por uma associação de chave estrangeira. É usado principalmente em associações de muitos-para-um
e um-para-um.
 */

class RegistroLog {
}