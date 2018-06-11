package com.mumu.joshautomationservice;

/**
 * ICommandService
 * this defines the interface between service and client
 */

public interface ICommandService {
    int CODE_RUN_COMMAND = 1;
    int CODE_DESTROY_ALL = 2;

    void runCommand(String cmd);
    void destroyAll();
}
