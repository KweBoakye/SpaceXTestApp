//
//  LoadableLaunches.swift
//  spaceXTestApp
//
//  Created by Kweku on 22/11/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import shared

enum LoadableLaunches {
    case loading
    case result([RocketLaunch])
    case error(String)
}
