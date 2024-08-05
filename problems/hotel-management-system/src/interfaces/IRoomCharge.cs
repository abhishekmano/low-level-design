namespace hotel_management_system.interfaces
{
    //Decorator Patter
    public abstract class BaseRoomCharge
    {
        public double Cost { get; set; }
        public abstract double GetCost();
    }

    public class RoomCharge : BaseRoomCharge
    {
        public double Cost { get; set; }

        public override double GetCost()
        {
            return Cost;
        }
    }

    public class RoomServiceCharge : BaseRoomCharge
    {
        public BaseRoomCharge BaseRoomCharge { get; set; }
        public double Cost { get; set; }

        public override double GetCost()
        {
            return BaseRoomCharge.GetCost() + Cost;
        }
    }

    public class RoomPurchaseCharge : BaseRoomCharge
    {
        public BaseRoomCharge BaseRoomCharge { get; set; }
        public double Cost { get; set; }

        public override double GetCost()
        {
            return BaseRoomCharge.GetCost() + Cost;
        }
    }
}
