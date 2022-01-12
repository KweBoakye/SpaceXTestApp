import SwiftUI
import shared



struct ContentView: View {
    
    @ObservedObject private var spaceXViewModel: SpaceXViewModel
    let spaceXController: SpaceXController
    
    init(spaceXViewModel: SpaceXViewModel ) {
        self.spaceXViewModel = spaceXViewModel
        self.spaceXController =  Dependencies().getSpaceXController(spaceXPresenterInterface: spaceXViewModel)
    }
    
    var body: some View {
        NavigationView {
            listView()
                .navigationTitle("SpaceX Launches")
                .navigationBarItems(trailing:
                                        Button("Reload"){
                                            self.spaceXController.loadAndDisplayLaunches(forceReload: true)
                                        })
        }.onAppear {
            self.spaceXController.loadAndDisplayLaunches(forceReload: false)
        }
    }
    
    private func listView() -> AnyView {
        switch spaceXViewModel.launches {
        case .loading: return AnyView(
              ProgressView()
                .scaleEffect(3,anchor: .center)
                .progressViewStyle(CircularProgressViewStyle(tint: .blue)))
        case .result(let launches): return AnyView(List(launches) { launch in
            RocketLaunchRow(rocketLaunch: launch)
        })
        case.error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
}


extension RocketLaunch: Identifiable {}
