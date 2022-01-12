//
//  SpaceXViewModel.swift
//  spaceXTestApp
//
//  Created by Kweku on 22/11/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import shared

class SpaceXViewModel: ObservableObject, SpaceXPresenterInterface {
    
    
    func showLaunches(launches: [RocketLaunch]) {
        self.launches = .result(launches)
    }
    
    func showLoading(){
        self.launches = .loading
    }
    
    func showLaunchesError(errors: [KotlinException]) {
        self.launches = .error(errors.debugDescription)
    }
    
  //  func loadLaunches
    
    @Published var launches = LoadableLaunches.loading
    
}
