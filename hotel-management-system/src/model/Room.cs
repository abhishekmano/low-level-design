public class Room{
    public int RoomNumber { get; set; }
    public int Floor { get; set; }
    public double Price {get; set;}
    public List<Key> Keys {get;set;}
    public RoomStyle RoomStyle {get; set;}
    public RoomStatus RoomStatus {get;set;}
    public List<HouseKeepingLog> HouseKeepingLogs {get;set;}

}
public class RoomController {
    public static void  AddHouseKeepingToRoom(Room room , HouseKeepingLog log){
        room.HouseKeepingLogs.Add(log);
    }
}
public enum RoomStyle{
    STANDARD , DELUXE , FAMILY_SUITE
}
public enum  RoomStatus {
    AVAILABLE, RESERVED , NOT_AVAILABLE , OCCUPIED , SERVICE
}



public class Key{
    public int Id { get; set; }
    public string  BarCode { get; set; }
    public DateTime IssuedAt { get; set; }
    public bool IsMain  { get; set; }
    public bool IsActive {get;set;}

}