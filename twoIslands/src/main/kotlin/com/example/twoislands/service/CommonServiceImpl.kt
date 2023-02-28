package com.example.twoislands.service

import org.springframework.stereotype.Service


@Service
class CommonServiceImpl : CommonService {

    override fun serchByVector(x: Int, y: Int, arr: Array<IntArray>): Int {
        val counts = mutableListOf<Int>()
        val maxX = arr.size
        val maxY = arr[0].size

        var i = 1
        var j = 0

        while ((y + j) < maxY) {
            if ((x + i) < maxX && arr[x + i][y + j] == 0) {
                i += 1
            }
            if ((x + i) != (maxX - 1) && i != 1) counts += (i - 1)
            j += 1
            i = j
        }
        i = 0
        j = 1
        while ((x + i) < maxX) {
            if ((y + j) < maxY && arr[x + i][y + j] == 0) {
                j += 1
            }
            if ((y + j) != (maxY - 1) && j != 1) counts += (j - 1)
            i += 1
            j = i
        }

        return 0
    }
}