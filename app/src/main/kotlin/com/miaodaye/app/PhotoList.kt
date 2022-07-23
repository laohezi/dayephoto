package com.miaodaye.app


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.annotation.Id
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import java.io.File
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType


class  Photo(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
    lateinit var url:String
 }

class  PhotoData(){
    var id: Long = 0L
    lateinit var url:String
}

@Controller
@RequestMapping("/photo")
class PhotoListControoler(){

    private lateinit var repository: PhotoListRepository

    @Autowired
    constructor(repository: PhotoListRepository) : this() {

        this.repository = repository
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun scanPhoto(@RequestParam("dir")dir: String): MutableList<Photo> {
       val list= repository.findAll()
        return  list
    }

}

interface  PhotoListRepository : JpaRepository<Photo, Long> {

}

@Controller
@RequestMapping("/photoScan")
class PhotoListFileScanner(){
    private lateinit var repository: PhotoListRepository

    @Autowired
    constructor(repository: PhotoListRepository) : this() {

        this.repository = repository
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun scanPhoto(@RequestParam("dir")dir: String): List<out File> {
        val files = ArrayList<File>()
        dir?.let {
            val dir = File(dir)
            if (dir.exists() && dir.isDirectory) {
                return dir.listFiles().toList().apply {
                    forEach {
                        println(it.absolutePath)

                    }
                }
            }
        }
        return files
    }
}


class  PhotoScanTask(){



}