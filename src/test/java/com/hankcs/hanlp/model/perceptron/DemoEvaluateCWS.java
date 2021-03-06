package com.hankcs.hanlp.model.perceptron;

import java.io.IOException;

import static com.hankcs.hanlp.classification.utilities.io.ConsoleLogger.logger;


public class DemoEvaluateCWS
{
    public static void main(String[] args) throws IOException
    {
        logger.start("开始训练...\n");
        PerceptronTrainer trainer = new CWSTrainer();
        PerceptronTrainer.Result result = trainer.train(MSR.TRAIN_PATH, MSR.GOLD_PATH, MSR.MODEL_PATH,
                                                        0.0, // 压缩比对准确率的影响很小
                                                        50, // 一般5个迭代就差不多收敛了
                                                        1 // 单线程的平均感知机算法收敛更稳定
        );
        logger.finish(" 训练完毕\n");

        double[] prf = result.prf;
        System.out.printf("P: %.2f R: %.2f F1: %.2f\n", prf[0], prf[1], prf[2]);
        // P: 96.69 R: 96.38 F1: 96.53
    }
}