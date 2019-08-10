import scala.collection.mutable.ArrayBuffer

object MontyHall extends App {

  println(" Test MontyHall problem")

  val r = scala.util.Random
  var wins = 0.0

  def setGame(r: scala.util.Random): ArrayBuffer[String]={
    var door = ArrayBuffer[String]()
    door+= "Goat"
    door+= "Goat"
    door+= "Goat"

    door(r.nextInt(3)) = "Car"
    door
  }

  def gameThread(switch:Boolean):Boolean={

    var door = setGame(r)
    //println(door)
    var choice = r.nextInt(3)
    //println(choice)
    var inList = List[Int]()
    var idTodelete = 0


    for(i <- 0 to 2){

      if(i != choice ){
        inList = i :: inList
      }
    }

    //println(inList)
    for(j <- inList){
      if(door(j) != "Goat"){
        idTodelete = j
      }
    }

    if(switch){

      choice = idTodelete
    }

    door(choice) == "Car"

  }

  val runs = 100000

  for( a <- 1 to runs){

    if(gameThread(false)){
      wins+=1
      //println("win")
    }
    else{
      //println("loss")
    }



  }


  println("Total Wins " , wins/runs)


}
