//
//  RocketLaunchRow.swift
//  spaceXTestApp
//
//  Created by Kweku on 22/11/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketLaunchRow: View {
    var rocketLaunch: RocketLaunch
    var body: some View {
        HStack() {
            VStack(alignment: .leading, spacing: 10.0) {
                Text("LaunchName: \(rocketLaunch.missionName)")
                Text(launchText).foregroundColor(launchColor)
                Text("Launch Year: \(String(rocketLaunch.launchYear))")
                Text("Launch Details: \(rocketLaunch.details ?? "")")
            }
            Spacer()
        }
    }
}

extension RocketLaunchRow {
    private var launchText: String {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? "Successful" : "Unsuccessful"
        } else {
            return "No Data"
        }
    }
    
    private var launchColor: Color {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? Color.green : Color.red
        } else {
           return Color.gray
        }
    }
}

struct RocketLaunchRow_Previews: PreviewProvider {
    static var previews: some View {
        RocketLaunchRow(rocketLaunch: RocketLaunch(flightNumber: 1,
                                                   missionName: "mission", launchYear: 2020,
                                                   launchDateUTC: "launchDateUTC",
                                                   rocket: Rocket(
                                                    id: "ID",
                                                    name: "name",
                                                    type: "type"
                                                   ),
                                                   details: "details",
                                                   launchSuccess: true,
                                                   links: Links(missionPatchUrl: "missionPatchUrl"
                                                                , articleUrl: "articleUrl")))
    }
}
