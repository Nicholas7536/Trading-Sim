import java.util.Random;

public enum BookSide {
    BUY,
    SELL;
    private static final Random random = new Random();

    public static BookSide getRandomSide() {
        int randomInt = random.nextInt(2);
        return (randomInt == 0) ? BUY : SELL;
    }
}
/*
) --------------------------------------------------------------
        ADD: BUY: AAA order: BUY TGT at $10.00, Orig Vol: 50, Rem Vol: 50, Fill Vol: 0, CXL Vol: 0, ID: AAATGT$10.00595271751644600
        Product: TGT
        Side: BUY
        Price: $10.00
        AAA order: BUY TGT at $10.00, Orig Vol: 50, Rem Vol: 50, Fill Vol: 0, CXL Vol: 0, ID: AAATGT$10.00595271751644600
        Side: SELL
<Empty>
2) --------------------------------------------------------------
        ADD: BUY: BBB order: BUY TGT at $10.00, Orig Vol: 60, Rem Vol: 60, Fill Vol: 0, CXL Vol: 0, ID: BBBTGT$10.00595271804400700
        Product: TGT
        Side: BUY
        Price: $10.00
        AAA order: BUY TGT at $10.00, Orig Vol: 50, Rem Vol: 50, Fill Vol: 0, CXL Vol: 0, ID: AAATGT$10.00595271751644600
        BBB order: BUY TGT at $10.00, Orig Vol: 60, Rem Vol: 60, Fill Vol: 0, CXL Vol: 0, ID: BBBTGT$10.00595271804400700
        Side: SELL
<Empty>
3) --------------------------------------------------------------
        ADD: BUY: CCC order: BUY TGT at $9.95, Orig Vol: 70, Rem Vol: 70, Fill Vol: 0, CXL Vol: 0, ID: CCCTGT$9.95595271804932600
        Product: TGT
        Side: BUY
        Price: $10.00
        AAA order: BUY TGT at $10.00, Orig Vol: 50, Rem Vol: 50, Fill Vol: 0, CXL Vol: 0, ID: AAATGT$10.00595271751644600
        BBB order: BUY TGT at $10.00, Orig Vol: 60, Rem Vol: 60, Fill Vol: 0, CXL Vol: 0, ID: BBBTGT$10.00595271804400700
        Price: $9.95
        CCC order: BUY TGT at $9.95, Orig Vol: 70, Rem Vol: 70, Fill Vol: 0, CXL Vol: 0, ID: CCCTGT$9.95595271804932600
        Side: SELL
<Empty>
4) --------------------------------------------------------------
        ADD: BUY: DDD order: BUY TGT at $9.90, Orig Vol: 25, Rem Vol: 25, Fill Vol: 0, CXL Vol: 0, ID: DDDTGT$9.90595271805712300
        Product: TGT
        Side: BUY
        Price: $10.00
        AAA order: BUY TGT at $10.00, Orig Vol: 50, Rem Vol: 50, Fill Vol: 0, CXL Vol: 0, ID: AAATGT$10.00595271751644600
        BBB order: BUY TGT at $10.00, Orig Vol: 60, Rem Vol: 60, Fill Vol: 0, CXL Vol: 0, ID: BBBTGT$10.00595271804400700
        Price: $9.95
        CCC order: BUY TGT at $9.95, Orig Vol: 70, Rem Vol: 70, Fill Vol: 0, CXL Vol: 0, ID: CCCTGT$9.95595271804932600
        Price: $9.90
        DDD order: BUY TGT at $9.90, Orig Vol: 25, Rem Vol: 25, Fill Vol: 0, CXL Vol: 0, ID: DDDTGT$9.90595271805712300
        Side: SELL
<Empty>
5) --------------------------------------------------------------
        ADD: SELL: EEE order: SELL TGT at $10.10, Orig Vol: 120, Rem Vol: 120, Fill Vol: 0, CXL Vol: 0, ID: EEETGT$10.10595271806503100
        Product: TGT
        Side: BUY
        Price: $10.00
        AAA order: BUY TGT at $10.00, Orig Vol: 50, Rem Vol: 50, Fill Vol: 0, CXL Vol: 0, ID: AAATGT$10.00595271751644600
        BBB order: BUY TGT at $10.00, Orig Vol: 60, Rem Vol: 60, Fill Vol: 0, CXL Vol: 0, ID: BBBTGT$10.00595271804400700
        Price: $9.95
        CCC order: BUY TGT at $9.95, Orig Vol: 70, Rem Vol: 70, Fill Vol: 0, CXL Vol: 0, ID: CCCTGT$9.95595271804932600
        Price: $9.90
        DDD order: BUY TGT at $9.90, Orig Vol: 25, Rem Vol: 25, Fill Vol: 0, CXL Vol: 0, ID: DDDTGT$9.90595271805712300
        Side: SELL
        Price: $10.10
        EEE order: SELL TGT at $10.10, Orig Vol: 120, Rem Vol: 120, Fill Vol: 0, CXL Vol: 0, ID: EEETGT$10.10595271806503100
        6) --------------------------------------------------------------
        ADD: SELL: EEE order: SELL TGT at $10.20, Orig Vol: 45, Rem Vol: 45, Fill Vol: 0, CXL Vol: 0, ID: EEETGT$10.20595271807621200
        Product: TGT
        Side: BUY
        Price: $10.00
        AAA order: BUY TGT at $10.00, Orig Vol: 50, Rem Vol: 50, Fill Vol: 0, CXL Vol: 0, ID: AAATGT$10.00595271751644600
        BBB order: BUY TGT at $10.00, Orig Vol: 60, Rem Vol: 60, Fill Vol: 0, CXL Vol: 0, ID: BBBTGT$10.00595271804400700
        Price: $9.95
        CCC order: BUY TGT at $9.95, Orig Vol: 70, Rem Vol: 70, Fill Vol: 0, CXL Vol: 0, ID: CCCTGT$9.95595271804932600
        Price: $9.90
        DDD order: BUY TGT at $9.90, Orig Vol: 25, Rem Vol: 25, Fill Vol: 0, CXL Vol: 0, ID: DDDTGT$9.90595271805712300
        Side: SELL
        Price: $10.10
        EEE order: SELL TGT at $10.10, Orig Vol: 120, Rem Vol: 120, Fill Vol: 0, CXL Vol: 0, ID: EEETGT$10.10595271806503100
        Price: $10.20
        EEE order: SELL TGT at $10.20, Orig Vol: 45, Rem Vol: 45, Fill Vol: 0, CXL Vol: 0, ID: EEETGT$10.20595271807621200
        7) --------------------------------------------------------------
        ADD: SELL: FFF order: SELL TGT at $10.25, Orig Vol: 90, Rem Vol: 90, Fill Vol: 0, CXL Vol: 0, ID: FFFTGT$10.25595271808923900
        Product: TGT
        Side: BUY
        Price: $10.00
        AAA order: BUY TGT at $10.00, Orig Vol: 50, Rem Vol: 50, Fill Vol: 0, CXL Vol: 0, ID: AAATGT$10.00595271751644600
        BBB order: BUY TGT at $10.00, Orig Vol: 60, Rem Vol: 60, Fill Vol: 0, CXL Vol: 0, ID: BBBTGT$10.00595271804400700
        Price: $9.95
        CCC order: BUY TGT at $9.95, Orig Vol: 70, Rem Vol: 70, Fill Vol: 0, CXL Vol: 0, ID: CCCTGT$9.95595271804932600
        Price: $9.90
        DDD order: BUY TGT at $9.90, Orig Vol: 25, Rem Vol: 25, Fill Vol: 0, CXL Vol: 0, ID: DDDTGT$9.90595271805712300
        Side: SELL
        Price: $10.10
        EEE order: SELL TGT at $10.10, Orig Vol: 120, Rem Vol: 120, Fill Vol: 0, CXL Vol: 0, ID: EEETGT$10.10595271806503100
        Price: $10.20
        EEE order: SELL TGT at $10.20, Orig Vol: 45, Rem Vol: 45, Fill Vol: 0, CXL Vol: 0, ID: EEETGT$10.20595271807621200
        Price: $10.25
        FFF order: SELL TGT at $10.25, Orig Vol: 90, Rem Vol: 90, Fill Vol: 0, CXL Vol: 0, ID: FFFTGT$10.25595271808923900
        8) --------------------------------------------------------------
        ADD: SELL: AAA order: SELL TGT at $10.00, Orig Vol: 200, Rem Vol: 200, Fill Vol: 0, CXL Vol: 0, ID: AAATGT$10.00595271810557400
        PARTIAL FILL: (SELL 110) AAA order: SELL TGT at $10.00, Orig Vol: 200, Rem Vol: 90, Fill Vol: 110, CXL Vol: 0, ID: AAATGT$10.00595271810557400
        FILL: (BUY 50) AAA order: BUY TGT at $10.00, Orig Vol: 50, Rem Vol: 0, Fill Vol: 50, CXL Vol: 0, ID: AAATGT$10.00595271751644600
        FILL: (BUY 60) BBB order: BUY TGT at $10.00, Orig Vol: 60, Rem Vol: 0, Fill Vol: 60, CXL Vol: 0, ID: BBBTGT$10.00595271804400700
        Product: TGT
        Side: BUY
        Price: $9.95
        CCC order: BUY TGT at $9.95, Orig Vol: 70, Rem Vol: 70, Fill Vol: 0, CXL Vol: 0, ID: CCCTGT$9.95595271804932600
        Price: $9.90
        DDD order: BUY TGT at $9.90, Orig Vol: 25, Rem Vol: 25, Fill Vol: 0, CXL Vol: 0, ID: DDDTGT$9.90595271805712300
        Side: SELL
        Price: $10.00
        AAA order: SELL TGT at $10.00, Orig Vol: 200, Rem Vol: 90, Fill Vol: 110, CXL Vol: 0, ID: AAATGT$10.00595271810557400
        Price: $10.10
        EEE order: SELL TGT at $10.10, Orig Vol: 120, Rem Vol: 120, Fill Vol: 0, CXL Vol: 0, ID: EEETGT$10.10595271806503100
        Price: $10.20
        EEE order: SELL TGT at $10.20, Orig Vol: 45, Rem Vol: 45, Fill Vol: 0, CXL Vol: 0, ID: EEETGT$10.20595271807621200
        Price: $10.25
        FFF order: SELL TGT at $10.25, Orig Vol: 90, Rem Vol: 90, Fill Vol: 0, CXL Vol: 0, ID: FFFTGT$10.25595271808923900
        9) --------------------------------------------------------------
        ADD: BUY: BBB order: BUY TGT at $10.10, Orig Vol: 200, Rem Vol: 200, Fill Vol: 0, CXL Vol: 0, ID: BBBTGT$10.10595271817310900
        FILL: (SELL 90) AAA order: SELL TGT at $10.00, Orig Vol: 200, Rem Vol: 0, Fill Vol: 200, CXL Vol: 0, ID: AAATGT$10.00595271810557400
        PARTIAL FILL: (BUY 90) BBB order: BUY TGT at $10.10, Orig Vol: 200, Rem Vol: 110, Fill Vol: 90, CXL Vol: 0, ID: BBBTGT$10.10595271817310900
        PARTIAL FILL: (SELL 110) EEE order: SELL TGT at $10.10, Orig Vol: 120, Rem Vol: 10, Fill Vol: 110, CXL Vol: 0, ID: EEETGT$10.10595271806503100
        FILL: (BUY 110) BBB order: BUY TGT at $10.10, Orig Vol: 200, Rem Vol: 0, Fill Vol: 200, CXL Vol: 0, ID: BBBTGT$10.10595271817310900
        Product: TGT
        Side: BUY
        Price: $9.95
        CCC order: BUY TGT at $9.95, Orig Vol: 70, Rem Vol: 70, Fill Vol: 0, CXL Vol: 0, ID: CCCTGT$9.95595271804932600
        Price: $9.90
        DDD order: BUY TGT at $9.90, Orig Vol: 25, Rem Vol: 25, Fill Vol: 0, CXL Vol: 0, ID: DDDTGT$9.90595271805712300
        Side: SELL
        Price: $10.10
        EEE order: SELL TGT at $10.10, Orig Vol: 120, Rem Vol: 10, Fill Vol: 110, CXL Vol: 0, ID: EEETGT$10.10595271806503100
        Price: $10.20
        EEE order: SELL TGT at $10.20, Orig Vol: 45, Rem Vol: 45, Fill Vol: 0, CXL Vol: 0, ID: EEETGT$10.20595271807621200
        Price: $10.25
        FFF order: SELL TGT at $10.25, Orig Vol: 90, Rem Vol: 90, Fill Vol: 0, CXL Vol: 0, ID: FFFTGT$10.25595271808923900
        10) --------------------------------------------------------------
        CANCEL: SELL Order: EEETGT$10.20595271807621200 Cxl Qty: 45
        Product: TGT
        Side: BUY
        Price: $9.95
        CCC order: BUY TGT at $9.95, Orig Vol: 70, Rem Vol: 70, Fill Vol: 0, CXL Vol: 0, ID: CCCTGT$9.95595271804932600
        Price: $9.90
        DDD order: BUY TGT at $9.90, Orig Vol: 25, Rem Vol: 25, Fill Vol: 0, CXL Vol: 0, ID: DDDTGT$9.90595271805712300
        Side: SELL
        Price: $10.10
        EEE order: SELL TGT at $10.10, Orig Vol: 120, Rem Vol: 10, Fill Vol: 110, CXL Vol: 0, ID: EEETGT$10.10595271806503100
        Price: $10.25
        FFF order: SELL TGT at $10.25, Orig Vol: 90, Rem Vol: 90, Fill Vol: 0, CXL Vol: 0, ID: FFFTGT$10.25595271808923900
        11) --------------------------------------------------------------
        ADD: SELL: CCC order: SELL TGT at $9.90, Orig Vol: 95, Rem Vol: 95, Fill Vol: 0, CXL Vol: 0, ID: CCCTGT$9.90595271826285300
        PARTIAL FILL: (SELL 70) CCC order: SELL TGT at $9.90, Orig Vol: 95, Rem Vol: 25, Fill Vol: 70, CXL Vol: 0, ID: CCCTGT$9.90595271826285300
        FILL: (BUY 70) CCC order: BUY TGT at $9.95, Orig Vol: 70, Rem Vol: 0, Fill Vol: 70, CXL Vol: 0, ID: CCCTGT$9.95595271804932600
        FILL: (SELL 25) CCC order: SELL TGT at $9.90, Orig Vol: 95, Rem Vol: 0, Fill Vol: 95, CXL Vol: 0, ID: CCCTGT$9.90595271826285300
        FILL: (BUY 25) DDD order: BUY TGT at $9.90, Orig Vol: 25, Rem Vol: 0, Fill Vol: 25, CXL Vol: 0, ID: DDDTGT$9.90595271805712300
<Empty>
Side: SELL
        Price: $10.10
        EEE order: SELL TGT at $10.10, Orig Vol: 120, Rem Vol: 10, Fill Vol: 110, CXL Vol: 0, ID: EEETGT$10.10595271806503100
        Price: $10.25
        FFF order: SELL TGT at $10.25, Orig Vol: 90, Rem Vol: 90, Fill Vol: 0, CXL Vol: 0, ID: FFFTGT$10.25595271808923900
        12) --------------------------------------------------------------
        ADD: BUY: DDD order: BUY TGT at $10.25, Orig Vol: 100, Rem Vol: 100, Fill Vol: 0, CXL Vol: 0, ID: DDDTGT$10.25595271827144200
        FILL: (SELL 10) EEE order: SELL TGT at $10.10, Orig Vol: 120, Rem Vol: 0, Fill Vol: 120, CXL Vol: 0, ID: EEETGT$10.10595271806503100
        PARTIAL FILL: (BUY 10) DDD order: BUY TGT at $10.25, Orig Vol: 100, Rem Vol: 90, Fill Vol: 10, CXL Vol: 0, ID: DDDTGT$10.25595271827144200
        FILL: (SELL 90) FFF order: SELL TGT at $10.25, Orig Vol: 90, Rem Vol: 0, Fill Vol: 90, CXL Vol: 0, ID: FFFTGT$10.25595271808923900
        FILL: (BUY 90) DDD order: BUY TGT at $10.25, Orig Vol: 100, Rem Vol: 0, Fill Vol: 100, CXL Vol: 0, ID: DDDTGT$10.25595271827144200
        Product: TGT
        Side: BUY
<Empty>
Side: SELL
<Empty>


 */