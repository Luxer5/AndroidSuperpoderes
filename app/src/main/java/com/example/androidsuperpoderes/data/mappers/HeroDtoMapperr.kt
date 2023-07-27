import com.example.androidsuperpoderes.data.dto.HeroDTO
import com.example.androidsuperpoderes.data.local.model.HeroLocal
import com.example.androidsuperpoderes.domain.model.HeroModel

fun HeroDTO.toHeroModel() = HeroModel(
    name = name?: "",
    photoUrl = photo?: "",
    id = id?:"",
    description = description?:"",
    favorite = favorite?:false
)

fun HeroDTO.toHeroLocal() = HeroLocal(
    id = id?: "",
    name = name?: "",
    photoUrl = photo?: "",
    favorite = favorite?: false,
    description = description?: ""
)

fun HeroLocal.toHeroModel() = HeroModel(
    name = name,
    photoUrl = photoUrl,
    id = id,
    description = description,
    favorite = favorite
)
fun HeroModel.toHeroLocal() = HeroLocal(
    name = name,
    photoUrl = photoUrl,
    description = description,
    favorite = favorite,
    id = id
)
