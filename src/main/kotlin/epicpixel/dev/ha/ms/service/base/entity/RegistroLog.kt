package epicpixel.dev.ha.ms.service.base.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDateTime
/*
Cada Log deve ter informações como o ID do usuário, a ação realizada, a data e hora da ação, etc.
@Entity:
@Table:
@Id:
@GeneratedValue:
@Column:
@JoinColumn:

*/
@Entity
class RegistroLog (){
    @Id
    @GeneratedValue
    val idRegistro: Int = 0
    var dataHora: LocalDateTime = LocalDateTime.now()
    @Column (nullable = false)
    var acaoRealizada: String = ""
    val idUsuario: Int = 0
    var detalhesAdicionais: String = ""
}