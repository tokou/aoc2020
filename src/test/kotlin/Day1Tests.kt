import kotlin.test.Test
import kotlin.test.assertEquals

fun pairThatSumsTo2020(input: List<Int>): Pair<Int, Int> = input.allPairs().first { it.first + it.second == 2020 }

fun tripleThatSumsTo2020(input: List<Int>): Triple<Int, Int, Int> =
    input.allTriples().first { it.first + it.second + it.third == 2020 }

fun List<Int>.allPairs(): List<Pair<Int, Int>> = flatMapIndexed { i, a -> drop(i + 1).map { b -> a to b } }

fun List<Int>.allTriples(): List<Triple<Int, Int, Int>> = flatMapIndexed { i, a ->
    drop(i + 1).flatMapIndexed { j, b ->
        drop(j + 1).map { c ->
            Triple(a, b, c)
        }
    }
}

fun String.parseInts(): List<Int> = split("\n").map(String::toInt)

class Day1Tests {
    @Test
    fun testExamples() {
        val input = listOf(1721, 979, 366, 299, 675, 1456)
        val pair = pairThatSumsTo2020(input)
        val triple = tripleThatSumsTo2020(input)
        assertEquals(514579, pair.first * pair.second)
        assertEquals(241861950, triple.first * triple.second * triple.third)
    }

    @Test
    fun testInput() {
        val input = day1.parseInts()
        val pair = pairThatSumsTo2020(input)
        val triple = tripleThatSumsTo2020(input)
        assertEquals(357504, pair.first * pair.second)
        assertEquals(12747392, triple.first * triple.second * triple.third)
    }

    val day1 = """
        1974
        1902
        1356
        1724
        1550
        1870
        1436
        1945
        1640
        1766
        1508
        1802
        1495
        1837
        131
        1754
        1296
        1627
        1768
        1451
        1252
        1566
        1611
        1531
        1868
        1745
        1894
        1799
        1948
        1930
        1400
        2003
        1777
        1279
        472
        1474
        1787
        1406
        1522
        1646
        1865
        1581
        1609
        1705
        1383
        1276
        1613
        1190
        1856
        1528
        1091
        1540
        1720
        1824
        1734
        1919
        1681
        1686
        1344
        1644
        1670
        1710
        1708
        1458
        1728
        1972
        1630
        1995
        1763
        1935
        451
        1392
        1990
        14
        1893
        1437
        1632
        1933
        1887
        1975
        1453
        1897
        2005
        2008
        1959
        1716
        1635
        1619
        1994
        1674
        1942
        1817
        1825
        196
        769
        1065
        1662
        1079
        1574
        1554
        1621
        1857
        1312
        1544
        2001
        1991
        1602
        1669
        1982
        1309
        1556
        1855
        1284
        1641
        1786
        735
        1921
        1661
        1934
        1552
        1012
        1748
        1782
        1631
        1607
        1659
        1997
        1600
        1594
        1798
        1405
        1790
        1993
        1960
        1717
        999
        1687
        1771
        1977
        1809
        1884
        1795
        1639
        1565
        1299
        1643
        1700
        2002
        1823
        1369
        1572
        1657
        1683
        1966
        1606
        1792
        1756
        1936
        1718
        2009
        1711
        1461
        1638
        1645
        1914
        1963
        1546
        1846
        1737
        1788
        1589
        1860
        1830
        1905
        1571
        1989
        1780
        1878
        1767
        1776
        1727
        1582
        1769
        1040
        694
        1327
        1623
        1688
        1694
        1932
        2000
        1969
        1590
        1425
        1917
        1324
        1852
        1753
        1743
        1551
    """.trimIndent()
}