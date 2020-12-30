package com.example.mvvmexample.ui.second

class Scanner {

    /**
     * Scan The BLE Device
     * Check the available BLE devices in the Surrounding
     * If the device is Already scanning then stop Scanning
     * Else start Scanning and check 10 seconds
     * Send the available devices as a callback to the system
     * Finish Scanning after 10 Seconds
     */
    fun scanBLEDevice(isContinuesScan: Boolean) {
        try {
            mIsContinuesScan = isContinuesScan
            if (mScanThread != null) {
                /**
                 * Already Running - No need to rescan
                 */
                return
            }
            mScanThread = Thread(mScanRunnable)
            mScanThread.start()
            /**
             * Stop Scanning after a Period of Time
             * Set a 10 Sec delay time and Stop Scanning
             * collect all the available devices in the 10 Second
             */
            if (!isContinuesScan) {
                mHandler?.postDelayed({
// Set a delay time to Scanning
                    stopScan(mDeviceObject)
                }, BLEConstants.SCAN_PERIOD) // Delay Period
            }
        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
    }
    private val mScanRunnable = Runnable {
        if (mBluetoothAdapter != null && mBluetoothAdapter!!.isEnabled) {
            scan()
        }
    }
    private fun scan() {
        if (isLollyPopOrAbove()) {// Start Scanning For Lollipop devices
            mBluetoothAdapter?.bluetoothLeScanner?.startScan(/*scanFilters(),
scanSettings(),*/scanCallback) // Start BLE device Scanning in a separate thread
        } else {
            mBluetoothAdapter?.startLeScan(mLeScanCallback) // Start Scanning for Below Lollipop device
        }}

}